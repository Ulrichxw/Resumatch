import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Everything an applicant can do: profile, ranked jobs, resume writing, applying. */
public class ApplicantHandler extends ApiHandler {

    private final MatchEngine matchEngine;
    private final GeminiClient gemini;

    public ApplicantHandler(DataStore store, SessionManager sessions, MatchEngine matchEngine, GeminiClient gemini) {
        super(store, sessions);
        this.matchEngine = matchEngine;
        this.gemini = gemini;
    }

    @Override
    protected Class<? extends User> requiredUser() { return Applicant.class; }

    @Override
    protected Object respond(Request request) throws Exception {
        Applicant applicant = (Applicant) request.user();
        switch (request.action()) {
            case "profile": return profile(applicant);
            case "saveProfile": return saveProfile(applicant, request);
            case "jobs": return rankedJobs(applicant);
            case "generateResume": return generateResume(applicant, request);
            case "resume": return Map.of("text", savedResume(applicant, request));
            case "saveResume": return saveResume(applicant, request);
            case "apply": return apply(applicant, request);
            case "applications": return applications(applicant);
            default: throw new IllegalArgumentException("Unknown action.");
        }
    }

    private Object profile(Applicant a) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("summary", a.getSummary());
        map.put("degree", a.getDegree());
        map.put("skills", a.getSkills());
        map.put("experience", a.getExperience());
        map.put("certifications", a.getCertifications());
        map.put("projects", a.getProjects());
        map.put("complete", a.isProfileComplete());
        return map;
    }

    private Object saveProfile(Applicant a, Request r) {
        a.updateProfile(r.text("summary"), r.text("degree"), r.text("skills"),
                r.text("experience"), r.text("certifications"), r.text("projects"));
        if (!a.isProfileComplete()) {
            throw new IllegalArgumentException("Saved, but please fill in your degree, skills and work experience to see jobs.");
        }
        return Map.of("ok", true);
    }

    /** Open jobs with a match score, best match first. */
    private Object rankedJobs(Applicant a) {
        requireProfile(a);
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobPosting job : store.openJobs()) {
            Map<String, Object> map = describe(job);
            map.put("score", matchEngine.totalScore(a, job));
            map.put("breakdown", matchEngine.breakdown(a, job));
            map.put("applied", store.hasApplied(a, job));
            map.put("hasResume", store.getResume(a, job) != null);
            list.add(map);
        }
        list.sort((x, y) -> Double.compare((Double) y.get("score"), (Double) x.get("score")));
        return list;
    }

    /** Gemini writes the resume. It is saved automatically and the applicant can edit it afterwards. */
    private Object generateResume(Applicant a, Request r) throws Exception {
        requireProfile(a);
        JobPosting job = store.findJob(r.number("jobId"));
        if (!job.isOpen()) throw new IllegalStateException("This job is no longer open.");
        String text = gemini.writeResume(a, job);
        store.saveResume(a, job, text);
        return Map.of("text", text);
    }

    private String savedResume(Applicant a, Request r) {
        String text = store.getResume(a, store.findJob(r.number("jobId")));
        return text == null ? "" : text;
    }

    private Object saveResume(Applicant a, Request r) {
        if (r.text("text").isEmpty()) throw new IllegalArgumentException("The resume cannot be empty.");
        store.saveResume(a, store.findJob(r.number("jobId")), r.text("text"));
        return Map.of("ok", true);
    }

    /** Only happens when the applicant clicks Apply. A copy of the saved resume goes to the employer. */
    private Object apply(Applicant a, Request r) {
        JobPosting job = store.findJob(r.number("jobId"));
        if (!job.isOpen()) throw new IllegalStateException("This job is no longer open.");
        if (store.hasApplied(a, job)) throw new IllegalStateException("You already applied to this job.");
        String resume = store.getResume(a, job);
        if (resume == null || resume.isBlank()) throw new IllegalStateException("Write and save a resume for this job first.");
        store.addApplication(new JobApplication(a, job, resume));
        return Map.of("ok", true);
    }

    private Object applications(Applicant a) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobApplication application : store.applicationsOf(a)) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", application.getId());
            map.put("jobTitle", application.getJob().getTitle());
            map.put("company", application.getJob().getEmployer().getCompanyName());
            map.put("status", application.getStatus());
            list.add(map);
        }
        return list;
    }

    private void requireProfile(Applicant a) {
        if (!a.isProfileComplete()) {
            throw new IllegalStateException("Complete your profile first (degree, skills and work experience).");
        }
    }
}
