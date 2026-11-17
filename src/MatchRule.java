public interface MatchRule {

    String getName();

    /** Share of the final score, from 0 to 1. All the weights together make 1. */
    double getWeight();

    /** A score from 0 to 100. Missing information scores 0. */
    double score(Applicant applicant, JobPosting job);
}
