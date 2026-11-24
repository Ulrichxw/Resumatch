import java.util.Map;

/** Tiny JSON helper so we need no outside library. */
public class Json {

    /** Turns Strings, numbers, booleans, Maps and Lists into JSON text. */
    public static String of(Object value) {
        if (value == null) return "null";
        if (value instanceof String text) return quote(text);
        if (value instanceof Number || value instanceof Boolean) return value.toString();

        if (value instanceof Map<?, ?> map) {
            StringBuilder out = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!first) out.append(',');
                first = false;
                out.append(quote(String.valueOf(entry.getKey()))).append(':').append(of(entry.getValue()));
            }
            return out.append('}').toString();
        }

        if (value instanceof Iterable<?> items) {
            StringBuilder out = new StringBuilder("[");
            boolean first = true;
            for (Object item : items) {
                if (!first) out.append(',');
                first = false;
                out.append(of(item));
            }
            return out.append(']').toString();
        }
        return quote(value.toString());   // enums and anything else
    }

    /** Wraps text in quotes and escapes special characters. */
    public static String quote(String text) {
        StringBuilder out = new StringBuilder("\"");
        for (char c : text.toCharArray()) {
            switch (c) {
                case '"' -> out.append("\\\"");
                case '\\' -> out.append("\\\\");
                case '\n' -> out.append("\\n");
                case '\r' -> out.append("\\r");
                case '\t' -> out.append("\\t");
                default -> {
                    if (c < 0x20) out.append(String.format("\\u%04x", (int) c));
                    else out.append(c);
                }
            }
        }
        return out.append('"').toString();
    }

    /** Finds the first "text": "..." in Gemini's answer and returns it as normal text. */
    public static String firstText(String json) {
        int key = json.indexOf("\"text\"");
        if (key < 0) throw new IllegalStateException("Gemini sent an answer we could not read.");
        int start = json.indexOf('"', json.indexOf(':', key) + 1) + 1;

        StringBuilder out = new StringBuilder();
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '"') return out.toString();          // end of the text
            if (c != '\\') { out.append(c); continue; }

            char next = json.charAt(++i);                 // a backslash starts an escape
            switch (next) {
                case 'n' -> out.append('\n');
                case 't' -> out.append('\t');
                case 'r' -> out.append('\r');
                case 'u' -> { out.append((char) Integer.parseInt(json.substring(i + 1, i + 5), 16)); i += 4; }
                default -> out.append(next);              // \" and \\ and \/
            }
        }
        throw new IllegalStateException("Gemini sent an answer we could not read.");
    }
}
