/** Certifications (10%): each certification named in the job text is worth 100 points (maximum 100). */
public class CertificationRule implements MatchRule {

    @Override
    public String getName() { return "Certifications"; }

    @Override
    public double getWeight() { return 0.10; }

    @Override
    public double score(Applicant applicant, JobPosting job) {
        double total = 0;
        for (String certification : applicant.getCertificationList()) {
            if (job.getSearchText().contains(certification)) total += 100;
        }
        return Math.min(100, total);
    }
}
