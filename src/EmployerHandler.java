import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Everything an employer can do: post jobs, close jobs, review applications. */
public class EmployerHandler extends ApiHandler {

    public EmployerHandler(DataStore store, SessionManager sessions) {
        super(store, sessions);
    }

    @Override
    protected Class<? extends User> requiredUser() { return Employer.class; }

    @Override
    protected Object respond(Request request) {
        Employer employer = (Employer) request.user();
        switch (request.action()) {
            case "postJob": return postJob(employer, request);
            case "myJobs": return myJobs(employer);
            case "closeJob": return closeJob(employer, request);
            case "applications": return applications(employer);
            case "decide": return decide(employer, request);
            default: throw new IllegalArgumentException("Unknown action.");
        }
    }

    /** A new job always starts as PENDING until the admin approves it. */
    private Object postJob(Employer employer, Request r) {
        LocalDate deadline;
        try {
            deadline = LocalDate.parse(r.text("deadline"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Choose a valid deadline date.");
        }
        store.addJob(new JobPosting(employer, r.text("title"), r.text("description"), r.text("requiredSkills"),
                r.text("qualifications"), r.text("location"), r.text("salary"), deadline));
        return Map.of("ok", true);
    }

    private Object myJobs(Employer employer) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobPosting job : store.jobsOf(employer)) list.add(describe(job));
        return list;
    }

    private Object closeJob(Employer employer, Request r) {
        JobPosting job = store.findJob(r.number("jobId"));
        if (job.getEmployer() != employer) throw new SecurityException("This is not your job posting.");
        job.close();
        return Map.of("ok", true);
    }

    /** The employer sees the applicant's name and the tailored resume sent with the application. */
    private Object applications(Employer employer) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobApplication application : store.applicationsFor(employer)) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", application.getId());
            map.put("applicant", application.getApplicant().getName());
            map.put("jobTitle", application.getJob().getTitle());
            map.put("status", application.getStatus());
            map.put("resume", application.getResumeText());
            list.add(map);
        }
        return list;
    }

    private Object decide(Employer employer, Request r) {
        JobApplication application = store.findApplication(r.number("id"));
        if (application.getJob().getEmployer() != employer) throw new SecurityException("This is not your application.");
        if (r.text("decision").equals("accept")) application.accept();
        else if (r.text("decision").equals("reject")) application.reject();
        else throw new IllegalArgumentException("Choose accept or reject.");
        return Map.of("ok", true);
    }
}
