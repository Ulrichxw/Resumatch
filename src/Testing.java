import java.time.LocalDate;

public class Testing {
    public static void main(String[] args) {
        // Create one user of each type
        Admin admin = new Admin("Ulrich", "Ulrich@mail.com", "secret123");
        Employer employer = new Employer("Ali", "ali@corp.com", "secret123", "Aboitz");
        Applicant applicant = new Applicant("Czarina", "czarina@mail.com", "secret123");

        System.out.println(admin.getWelcomeMessage());
        System.out.println(employer.getWelcomeMessage());
        System.out.println(applicant.getWelcomeMessage());

        // Password check
        System.out.println("Correct password: " + applicant.checkPassword("secret123"));
        System.out.println("Wrong password:   " + applicant.checkPassword("nope"));

        // Applicant profile
        System.out.println("Profile complete before? " + applicant.isProfileComplete());
        applicant.updateProfile("Fresh grad", "BS Computer Science", "Java, SQL, Teamwork",
                "Internship at ABC", "", "Job portal");
        System.out.println("Profile complete after?  " + applicant.isProfileComplete());
        System.out.println("Skills: " + applicant.getSkillList());

        // Job posting lifecycle
        JobPosting job = new JobPosting(employer, "Java Developer",
                "Build backend services using Java and SQL", "Java, SQL",
                "BS Computer Science", "Manila", "50000", LocalDate.now().plusDays(30));
        System.out.println("Status: " + job.getStatus() + ", open? " + job.isOpen());
        job.approve();
        System.out.println("Status: " + job.getStatus() + ", open? " + job.isOpen());

        // Simple keyword matching
        double skillMatch = Keywords.share(
                Keywords.words(job.getRequiredSkills()),
                Keywords.words(applicant.getSkills()));
        System.out.println("Skill match: " + (int) (skillMatch * 100) + "%");

        // Validation errors
        try {
            applicant.setEmail("not-an-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            job.approve(); // already approved
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
