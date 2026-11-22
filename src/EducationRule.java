
/** Education (10%): do the words of the applicant's degree appear in the job's qualifications? */
public class EducationRule implements MatchRule {

    @Override
    public String getName() { return "Education"; }

    @Override
    public double getWeight() { return 0.10; }

    @Override
    public double score(Applicant applicant, JobPosting job) {
        var degreeWords = Keywords.words(applicant.getDegree());
        var jobWords = Keywords.words(job.getQualifications() + " " + job.getTitle());
        return 100 * Keywords.share(degreeWords, jobWords);
    }
}
