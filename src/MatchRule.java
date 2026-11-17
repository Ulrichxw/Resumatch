//Declaring of methods that will be used to score applicants based on the job posting

public interface MatchRule {

    String getName();

    //this is for the weighted average
    double getWeight();

    //returns a score between 0 and 1, where 1 is a perfect match
    double score(Applicant applicant, JobPosting job);
}
