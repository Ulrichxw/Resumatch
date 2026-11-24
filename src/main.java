import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/** Start here. Builds the objects, connects the URLs to the handlers and starts the server. */
public class main {

    public static void main(String[] args) throws Exception {
        DataStore store = new DataStore();
        SessionManager sessions = new SessionManager();
        MatchEngine matchEngine = new MatchEngine();
        GeminiClient gemini = new GeminiClient();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/auth/", new AuthHandler(store, sessions));
        server.createContext("/api/applicant/", new ApplicantHandler(store, sessions, matchEngine, gemini));
        server.createContext("/api/employer/", new EmployerHandler(store, sessions));
        server.createContext("/api/admin/", new AdminHandler(store, sessions));
        server.createContext("/", new PageHandler());
        server.start();

        System.out.println("ResuMatch is running. Open http://localhost:8080 in your browser.");
        System.out.println("Sample logins:  student@demo.com / demo123   employer@demo.com / demo123   admin@resumatch.com / admin123");
        if (System.getenv("GEMINI_API_KEY") == null) {
            System.out.println("NOTE: GEMINI_API_KEY is not set, so 'Write resume' will not work until you set it.");
        }
    }
}
