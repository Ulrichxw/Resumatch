// Admin class from the parent class User.
public class Admin extends User { //extends means Admin inherits from User, so Admin has all the properties and methods of User, plus any additional ones defined in Admin.

    public Admin(String name, String email, String password) { //Admin constructor that takes name, email, and password as parameters and passes them to the User constructor using super(). 
        super(name, email, password); //super() calls the constructor of the parent class (User) to initialize the inherited properties.
    }

    @Override //Ovrerride the getRoleName() method from the parent class User and displays admin
    public String getRoleName() { return "Admin"; }

    @Override //Override the getWelcomeMessage() method from the parent class user so we can display admin panel message instead of the default welcome message.
    public String getWelcomeMessage() {
        return "Admin panel: " + getName() + ". Approve or reject job postings here.";
    }
}