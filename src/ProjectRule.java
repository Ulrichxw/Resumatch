/** Projects (10%): do the applicant's projects and technologies relate to the job? */
public class ProjectRule implements MatchRule {

    @Override
    public String getName() { return "Projects"; }

    @Override
    public double getWeight() { return 0.10; }

    @Override
    public double score(Applicant applicant, JobPosting job) {
        var projectWords = Keywords.words(applicant.getProjects());
        var jobWords = Keywords.words(job.getSearchText());
        return 100 * Keywords.relevance(projectWords, jobWords);
    }
}
