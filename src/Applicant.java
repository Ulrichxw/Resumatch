import java.util.List;

public class Applicant extends User {

    private String summary = "";
    private String degree = "";
    private String skills = "";          // comma separated, e.g. "Java, SQL, Teamwork"
    private String experience = "";
    private String certifications = "";  // comma separated
    private String projects = "";

    public Applicant(String name, String email, String password) {
        super(name, email, password);    // runs the User constructor
    }

    //allows the applicant to update their profile with a summary, degree, skills, experience, certifications, and projects. 
    //updareProfile is public so that it can be called from outside the class to update the applicant's profile information.
    public void updateProfile(String summary, String degree, String skills,
                              String experience, String certifications, String projects) {
        this.summary = clean(summary); //clean method trims whitespace and handles null values
        this.degree = clean(degree);
        this.skills = clean(skills);
        this.experience = clean(experience);
        this.certifications = clean(certifications);
        this.projects = clean(projects);
    }

// we use ! Because our goal is to check whether the applicant HAS filled in the required information, not whether the fields are empty.
    public boolean isProfileComplete() {
        return !degree.isEmpty() && !skills.isEmpty() && !experience.isEmpty();
    } //is empty checks if the string is empty or null, returns true if it is not empty and false if it is empty.
    //if it is empty, the profile is not complete and the applicant cannot use the job list.

    //the applicant cannot proceed to these steps until they have completed their profile with a degree, skills, and experience. This is to ensure that the applicant has the necessary qualifications and experience to apply for jobs.
    public String getSummary() {
         return summary; 
        }
    public String getDegree() {
         return degree; 
        }
    public String getSkills() {
         return skills; 
        }
    public String getExperience() {
         return experience; 
        }
    public String getCertifications() {
         return certifications; 
        }
    public String getProjects() {
         return projects; 
        }

    // convenience methods to get the skills and certifications as lists of strings, instead of comma-separated strings.
    public List<String> getSkillList() { return Keywords.csv(skills); } //List<String> means that the method returns a list of strings.
    public List<String> getCertificationList() { return Keywords.csv(certifications); } 

    private String clean(String text) {
        return text == null ? "" : text.trim();
    }


    @Override
    public String getRoleName() { return "Applicant"; }

    @Override
    public String getWelcomeMessage() {
        return "Welcome, " + getName() + "! Let's find jobs that match your profile.";
    }
}
