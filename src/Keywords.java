import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Small helper for comparing texts by their keywords. No AI here: just simple Java. */
public class Keywords {

    private static final Set<String> IGNORED = Set.of(
            "the", "and", "for", "with", "from", "that", "this", "are", "was", "will", "you", "your",
            "our", "have", "has", "can", "but", "not", "all", "any", "use", "used", "using", "work");

    /** "Java, SQL , Teamwork" -> ["java", "sql", "teamwork"] */
    public static List<String> csv(String text) {
        List<String> items = new ArrayList<>();
        if (text == null) return items;
        for (String part : text.split(",")) {
            String item = part.trim().toLowerCase();
            if (!item.isEmpty()) items.add(item);
        }
        return items;
    }

    /** The meaningful words of a text, in lower case. */
    public static Set<String> words(String text) {
        Set<String> result = new HashSet<>();
        if (text == null) return result;
        for (String word : text.toLowerCase().split("[^a-z0-9+#]+")) {
            if (word.length() >= 3 && !IGNORED.contains(word)) result.add(word);
        }
        return result;
    }

    /** What fraction (0 to 1) of the "wanted" words also appear in "found"? */
    public static double share(Set<String> wanted, Set<String> found) {
        if (wanted.isEmpty()) return 0;
        int count = 0;
        for (String word : wanted) {
            if (found.contains(word)) count++;
        }
        return (double) count / wanted.size();
    }

    /** How related two texts are (0 to 1). If 40% of the shorter text's words are shared, that already counts as full. */
    public static double relevance(Set<String> a, Set<String> b) {
        if (a.isEmpty() || b.isEmpty()) return 0;
        int shared = 0;
        for (String word : a) {
            if (b.contains(word)) shared++;
        }
        double overlap = (double) shared / Math.min(a.size(), b.size());
        return Math.min(1.0, overlap / 0.4);
    }
}
