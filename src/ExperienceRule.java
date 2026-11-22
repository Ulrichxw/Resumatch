/** Work experience (20%): do the applicant's past jobs sound like this job? */
public class ExperienceRule implements MatchRule {

    @Override
    public String getName() { return "Work experience"; }

    @Override
    public double getWeight() { return 0.20; }

    @Override
    public double score(Applicant applicant, JobPosting job) {
        var experienceWords = Keywords.words(applicant.getExperience());
        var jobWords = Keywords.words(job.getTitle() + " " + job.getDescription());
        return 100 * Keywords.relevance(experienceWords, jobWords);
    }
}
