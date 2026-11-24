
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Remembers who is logged in. After login the browser gets a random token and sends it with every request. */
public class SessionManager {

    private final Map<String, User> sessions = new HashMap<>();

    public String login(User user) {
        String token = UUID.randomUUID().toString();
        sessions.put(token, user);
        return token;
    }

    public User find(String token) {
        return token == null ? null : sessions.get(token);
    }

    public void logout(String token) {
        if (token != null) sessions.remove(token);
    }
}
