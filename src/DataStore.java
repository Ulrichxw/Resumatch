
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keeps everything in memory (lists). There is no database, so data resets when the server restarts.
 * Sample accounts are added at the start so you can try the site right away.
 */
public class DataStore {

    private final List<User> users = new ArrayList<>();
    private final List<JobPosting> jobs = new ArrayList<>();
    private final List<JobApplication> applications = new ArrayList<>();
    private final Map<String, String> resumes = new HashMap<>();   // "applicantId-jobId" -> resume text

    public DataStore() {
        addSampleData();
    }

    // ----- users -----
    public void addUser(User user) {
        if (findUser(user.getEmail()) != null) {
            throw new IllegalArgumentException("An account with this email already exists.");
        }
        users.add(user);
    }

    public User findUser(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email.trim())) return user;
        }
        return null;
    }

    // ----- jobs -----
    public void addJob(JobPosting job) { jobs.add(job); }

    public JobPosting findJob(int id) {
        for (JobPosting job : jobs) {
            if (job.getId() == id) return job;
        }
        throw new IllegalArgumentException("Job not found.");
    }

    public List<JobPosting> openJobs() {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting job : jobs) {
            if (job.isOpen()) result.add(job);
        }
        return result;
    }

    public List<JobPosting> jobsOf(Employer employer) {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting job : jobs) {
            if (job.getEmployer() == employer) result.add(job);
        }
        return result;
    }

    public List<JobPosting> jobsWithStatus(JobPosting.Status status) {
        List<JobPosting> result = new ArrayList<>();
        for (JobPosting job : jobs) {
            if (job.getStatus() == status) result.add(job);
        }
        return result;
    }

    // ----- resumes -----
    public void saveResume(Applicant applicant, JobPosting job, String text) {
        resumes.put(applicant.getId() + "-" + job.getId(), text);
    }

    public String getResume(Applicant applicant, JobPosting job) {
        return resumes.get(applicant.getId() + "-" + job.getId());
    }

    // ----- applications -----
    public boolean hasApplied(Applicant applicant, JobPosting job) {
        for (JobApplication application : applications) {
            if (application.getApplicant() == applicant && application.getJob() == job) return true;
        }
        return false;
    }

    public void addApplication(JobApplication application) { applications.add(application); }

    public JobApplication findApplication(int id) {
        for (JobApplication application : applications) {
            if (application.getId() == id) return application;
        }
        throw new IllegalArgumentException("Application not found.");
    }

    public List<JobApplication> applicationsOf(Applicant applicant) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication application : applications) {
            if (application.getApplicant() == applicant) result.add(application);
        }
        return result;
    }

    public List<JobApplication> applicationsFor(Employer employer) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication application : applications) {
            if (application.getJob().getEmployer() == employer) result.add(application);
        }
        return result;
    }

    // ----- sample data -----
    private void addSampleData() {
        users.add(new Admin("Site Admin", "admin@resumatch.com", "admin123"));

        Employer employer = new Employer("Demo Employer", "employer@demo.com", "demo123", "TechNova Inc.");
        users.add(employer);

        Applicant student = new Applicant("Demo Student", "student@demo.com", "demo123");
        student.updateProfile("Third-year IT student who enjoys building web applications.",
                "BS Information Technology", "Java, SQL, HTML, Teamwork, Communication",
                "Student assistant developer: fixed bugs and built small database reports for the school office.",
                "", "Library system in Java with a MySQL database");
        users.add(student);

        LocalDate deadline = LocalDate.now().plusDays(30);
        String[][] samples = {
                {"Junior Java Developer", "Build and maintain Java applications and SQL database reports with a small team.",
                        "Java, SQL, Teamwork", "Bachelor's degree in Information Technology or Computer Science", "Manila", "PHP 25,000 per month"},
                {"Web Developer Intern", "Create web pages using HTML and JavaScript and fix bugs reported by users.",
                        "HTML, JavaScript, Communication", "Student of Information Technology", "Remote", "PHP 10,000 per month"},
                {"Data Analyst", "Analyze data with Excel and SQL and present monthly reports.",
                        "SQL, Excel, Data Analysis", "Bachelor's degree in Statistics, Mathematics or IT", "Cebu", "PHP 28,000 per month"}};
        for (String[] s : samples) {
            JobPosting job = new JobPosting(employer, s[0], s[1], s[2], s[3], s[4], s[5], deadline);
            job.approve();
            jobs.add(job);
        }
    }
}
