import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/** Sends the web page (web/index.html) to the browser. It is read again on every visit, so you can edit and refresh. */
public class PageHandler implements HttpHandler {

    private final Path page = Path.of("web", "index.html");

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        boolean wanted = path.equals("/") || path.equals("/index.html");
        byte[] bytes;
        int status = 200;

        if (!wanted) {
            status = 404;
            bytes = "Page not found".getBytes(StandardCharsets.UTF_8);
        } else if (!Files.exists(page)) {
            status = 500;
            bytes = "web/index.html not found. Start the server from the ResuMatchSimple folder.".getBytes(StandardCharsets.UTF_8);
        } else {
            bytes = Files.readAllBytes(page);
        }

        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }
}
