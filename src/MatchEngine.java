
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MatchEngine {

    private final List<MatchRule> rules = new ArrayList<>();

    public MatchEngine() {
        rules.add(new SkillsRule());
        rules.add(new ExperienceRule());
        rules.add(new EducationRule());
        rules.add(new CertificationRule());
        rules.add(new ProjectRule());
    }

    /** The score of each rule, for example {"Skills": 66.7, "Education": 100.0, ...}. */
    public Map<String, Double> breakdown(Applicant applicant, JobPosting job) {
        Map<String, Double> scores = new LinkedHashMap<>();
        for (MatchRule rule : rules) {
            scores.put(rule.getName(), round(rule.score(applicant, job)));
        }
        return scores;
    }

    /** The final match score from 0 to 100. */
    public double totalScore(Applicant applicant, JobPosting job) {
        double total = 0;
        for (MatchRule rule : rules) {
            total += rule.getWeight() * rule.score(applicant, job);
        }
        return round(total);
    }

    private double round(double value) {
        return Math.round(value * 10.0) / 10.0;
    }
}
