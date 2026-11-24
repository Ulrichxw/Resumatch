import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ApiHandler implements HttpHandler {

    /** Everything a child needs to know about one request. */
    protected record Request(String action, Map<String, String> input, User user, String token) {
        /** The form value with this name, or "" when it is missing. */
        public String text(String key) {
            String value = input.get(key);
            return value == null ? "" : value.trim();
        }

        public int number(String key) {
            try {
                return Integer.parseInt(text(key));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("A number is missing or wrong: " + key);
            }
        }
    }

    protected final DataStore store;
    protected final SessionManager sessions;

    protected ApiHandler(DataStore store, SessionManager sessions) {
        this.store = store;
        this.sessions = sessions;
    }

    /** Which kind of user may use this handler? Return null to allow anyone (login and register). */
    protected abstract Class<? extends User> requiredUser();

    /** Do the work for one action (the last part of the URL) and return a Map, List or String to send back. */
    protected abstract Object respond(Request request) throws Exception;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        int status = 200;
        String json;
        try {
            String token = exchange.getRequestHeaders().getFirst("X-Token");
            User user = sessions.find(token);

            Class<? extends User> required = requiredUser();
            if (required != null && !required.isInstance(user)) {
                throw new SecurityException("Please log in with the correct account.");
            }

            String path = exchange.getRequestURI().getPath();
            String action = path.substring(path.lastIndexOf('/') + 1);
            json = Json.of(respond(new Request(action, readInput(exchange), user, token)));
        } catch (SecurityException e) {
            status = 403;
            json = Json.of(Map.of("error", e.getMessage()));
        } catch (IllegalArgumentException | IllegalStateException e) {
            status = 400;   // a rule was broken: show the message to the user
            json = Json.of(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            status = 500;
            json = Json.of(Map.of("error", "Server problem: " + e.getMessage()));
        }
        send(exchange, status, json);
    }

    /** The fields of a job posting that everybody may see. */
    protected Map<String, Object> describe(JobPosting job) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", job.getId());
        map.put("title", job.getTitle());
        map.put("company", job.getEmployer().getCompanyName());
        map.put("location", job.getLocation());
        map.put("salary", job.getSalary());
        map.put("deadline", job.getDeadline().toString());
        map.put("description", job.getDescription());
        map.put("qualifications", job.getQualifications());
        map.put("requiredSkills", job.getRequiredSkills());
        map.put("status", job.getStatus());
        return map;
    }

    // ----- reading and sending -----

    private Map<String, String> readInput(HttpExchange exchange) throws IOException {
        Map<String, String> input = new HashMap<>();
        parseForm(exchange.getRequestURI().getRawQuery(), input);
        parseForm(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8), input);
        return input;
    }

    /** "name=Ana&age=20" -> {name: Ana, age: 20} */
    private void parseForm(String text, Map<String, String> into) {
        if (text == null || text.isEmpty()) return;
        for (String pair : text.split("&")) {
            int equals = pair.indexOf('=');
            if (equals < 0) continue;
            into.put(URLDecoder.decode(pair.substring(0, equals), StandardCharsets.UTF_8),
                    URLDecoder.decode(pair.substring(equals + 1), StandardCharsets.UTF_8));
        }
    }

    private void send(HttpExchange exchange, int status, String json) throws IOException {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }
}
