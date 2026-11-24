import java.util.Map;

/** Register, log in, log out. Open to everyone. */
public class AuthHandler extends ApiHandler {

    public AuthHandler(DataStore store, SessionManager sessions) {
        super(store, sessions);
    }

    @Override
    protected Class<? extends User> requiredUser() { return null; }

    @Override
    protected Object respond(Request request) {
        switch (request.action()) {
            case "register": return register(request);
            case "login": return login(request);
            case "logout":
                sessions.logout(request.token());
                return Map.of("ok", true);
            case "me":
                if (request.user() == null) throw new SecurityException("Please log in.");
                return describeUser(request.user(), request.token());
            default: throw new IllegalArgumentException("Unknown action.");
        }
    }

    private Object register(Request request) {
        String role = request.text("role");
        User user;
        if (role.equals("applicant")) {
            user = new Applicant(request.text("name"), request.text("email"), request.text("password"));
        } else if (role.equals("employer")) {
            user = new Employer(request.text("name"), request.text("email"), request.text("password"), request.text("company"));
        } else {
            throw new IllegalArgumentException("Choose applicant or employer.");
        }
        store.addUser(user);
        return describeUser(user, sessions.login(user));
    }

    private Object login(Request request) {
        User user = store.findUser(request.text("email"));
        if (user == null || !user.checkPassword(request.text("password"))) {
            throw new IllegalArgumentException("Incorrect email or password.");
        }
        return describeUser(user, sessions.login(user));
    }

    /** POLYMORPHISM in action: getRoleName() and getWelcomeMessage() give a different answer for each kind of user. */
    private Map<String, Object> describeUser(User user, String token) {
        return Map.of("token", token, "name", user.getName(),
                "role", user.getRoleName(), "welcome", user.getWelcomeMessage());
    }
}
