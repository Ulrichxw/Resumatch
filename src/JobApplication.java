/** One application: who applied, to which job, with which resume, and what the employer decided. */
public class JobApplication {

    public enum Status { PENDING, ACCEPTED, REJECTED }

    private static int nextId = 1;

    private final int id;
    private final Applicant applicant; //points to the Applicant.java object (Who applied)
    private final JobPosting job;
    private final String resumeText;      // a copy taken when the applicant clicked Apply
    private Status status = Status.PENDING;

    public JobApplication(Applicant applicant, JobPosting job, String resumeText) {
        this.id = nextId++;
        this.applicant = applicant;
        this.job = job;
        this.resumeText = resumeText;
    }
    //Employers Decision

    //employer wants to accept the application
    public void accept() { decide(Status.ACCEPTED); }
    //Employer wants to reject the application
    public void reject() { decide(Status.REJECTED); }
    //once the employer has made a decision, the application cannot be changed
    private void decide(Status decision) { //Receives the decision Accepted or Rejected
        if (status != Status.PENDING) { //Checks the current status
            throw new IllegalStateException("This application was already " + status.name().toLowerCase() + ".");
        }
        status = decision;
    }

    public int getId() { return id; }
    public Applicant getApplicant() { return applicant; }
    public JobPosting getJob() { return job; }
    public String getResumeText() { return resumeText; }
    public Status getStatus() { return status; }
}
