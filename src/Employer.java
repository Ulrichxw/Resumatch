
public class Employer extends User {

    private String companyName;

    public Employer(String name, String email, String password, String companyName) { //Employer comstructor that takes name, email, password, and companyName as parameter.
        super(name, email, password); //super() calls the constructor of the parent class (User) to initialize the inherited properties.
        setCompanyName(companyName); // Call the setter to validate and set the company name.
    }

    public String getCompanyName() { 
        return companyName; 
    } // Getter for the company name.

    //Validation for the company name to ensure it is not null or blank.
    public final void setCompanyName(String companyName) {
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name is required.");
        }
        this.companyName = companyName.trim();
    }

    @Override
    public String getRoleName() { return "Employer"; }

    @Override
    public String getWelcomeMessage() {
        return "Hello, " + getName() + " (" + companyName + "). Post a job or review applications.";
    }
}
