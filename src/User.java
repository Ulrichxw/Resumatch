import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

//This file defines the User class, which is an abstract class that serves as a blueprint for different types of users in the system. It contains common properties and methods that all user types will share, such as id, name, email, and password management. The class also includes validation for user input and password hashing for security.

public abstract class User {
    //private = only accessible within this class to keep it secure and prevent external modification
    private static int nextId = 1;

    private final int id; //final means unique and cannot be changed after initialization
    private String name;
    private String email;
    private String passwordHash;   // we never keep the real password

    public User(String name, String email, String password) {
        this.id = nextId++; //assign a unique id to each user and increment for the next user
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // setters
    public final void setName(String name) {
        if (name == null || name.isBlank()) { //if no name or white space only
            throw new IllegalArgumentException("Name is required.");
        }
        this.name = name.trim(); //trim removes leading and trailing whitespace
    }

    public final void setEmail(String email) {
        if (email == null || !email.contains("@")) { //empty or does not contain @
            throw new IllegalArgumentException("Enter a valid email address.");
        }
        this.email = email.trim().toLowerCase();
    }

    public final void setPassword(String password) {
        if (password == null || password.length() < 6) { //empty or less than 6 characters
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }
        this.passwordHash = hash(password); //create a hash of the password and store it instead of the actual password
    }

    public boolean checkPassword(String password) {
        return passwordHash.equals(hash(password)); //compare the hash of the input password with the stored hash
    }

    private String hash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }


    public abstract String getRoleName(); 

    
    public String getWelcomeMessage() {
        return "Welcome, " + name + "!";
    }
}
