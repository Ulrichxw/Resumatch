import java.time.LocalDate; //represents a date without time, e.g. 2023-03-15

/** This class represents a job posting in the system created by employers */
public class JobPosting { //Object fields.
    //prevents invalid values so we created defined set of values.
    public enum Status { PENDING, APPROVED, REJECTED, CLOSED } //fixed set of possible statuses

    private static int nextId = 1;
    //the purpose of ID is to uniquely identify each job posting in the system. It is a static variable that is incremented each time a new job posting is created, ensuring that each job posting has a unique identifier.
    private final int id; //final prevents the value from being reassigned.
    private final Employer employer; //Storing an object belonging to Employer class, which represents the employer who created the job posting. This allows us to associate each job posting with the employer who created it.
    private final String title;
    private final String description;
    private final String requiredSkills;   // comma separated
    private final String qualifications;
    private final String location;
    private final String salary;
    private final LocalDate deadline;
    private Status status = Status.PENDING;   // every new job starts as pending, until an admin approves or rejects it.
                                              //satus can hold one of the four values defined in the Status enum: PENDING, APPROVED, REJECTED, or CLOSED.
    //Constructor
    public JobPosting(
        Employer employer, //parameters: temporary variables that holds
        String title,      //the values passed to the constructor
        String description,
        String requiredSkills,             
        String qualifications, 
        String location, 
        String salary, 
        LocalDate deadline
    ) { //checks whether any required fields is missing or blank.
        if (isBlank(title) || isBlank(description) || isBlank(requiredSkills)
                || isBlank(qualifications) || isBlank(location) || isBlank(salary)) 
            {
                throw new IllegalArgumentException("Please fill in every field of the job posting.");
        } //checks whether the deadline is in the past and is null/blank.
        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The deadline cannot be in the past.");
        }
        //assigns the validated information to the fields belonging to the newly created object.
        this.id = nextId++;
        this.employer = employer;
        this.title = title.trim();
        this.description = description.trim();
        this.requiredSkills = requiredSkills.trim();
        this.qualifications = qualifications.trim();
        this.location = location.trim();
        this.salary = salary.trim();
        this.deadline = deadline;
    }

    // controls changes to the job's status.
    public void approve() {
        requireStatus(Status.PENDING, "Only a pending job can be approved.");
        status = Status.APPROVED;
    }

    public void reject() {
        requireStatus(Status.PENDING, "Only a pending job can be rejected.");
        status = Status.REJECTED;
    } 

    public void close() {
        requireStatus(Status.APPROVED, "Only an approved job can be closed.");
        status = Status.CLOSED;
    }//returns true if the job is approved and the deadline has not passed, otherwise returns false.

    /** Applicants may only see jobs that are approved and not past the deadline. */
    public boolean isOpen() {
        return status == Status.APPROVED && !deadline.isBefore(LocalDate.now());
    } //determines whether a job posting is currently available for applicants to see.

    /** All the job text in lower case, used by the matching rules. */
    public String getSearchText() {
        return (title + " " + description + " " + qualifications + " " + requiredSkills).toLowerCase();
    }//combines important job information into one lowercase String for searching and matching.

    /**CheckS whether the status has the required statuses: PENDING, APPROVED or REJECTED */
    private void requireStatus(Status wantedStat, String message) {
        if (status != wantedStat) throw new IllegalStateException(message);
    } //wantedStat = parameter that represents the desired status.

    //checks whether a String is missing or contains no meaningful text.
    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    //allow other classes to retrieve information stored in the private fields of a JobPosting object.
    /**Because the fields are private, other classes cannot 
     * directly access them. Getters provide controlled access to read their values. */
    public int getId() {return id;}
    public Employer getEmployer() {return employer; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getRequiredSkills() { return requiredSkills; }
    public String getQualifications() { return qualifications; }
    public String getLocation() { return location; }
    public String getSalary() { return salary; }
    public LocalDate getDeadline() { return deadline; }
    public Status getStatus() { return status; }
}
