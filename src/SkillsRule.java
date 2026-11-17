//includes the computation of the score for the skills rule

import java.util.List;

public class SkillsRule implements MatchRule { //requires to follow the rules in MatchRule.java

    @Override
    public String getName() { //all other objects use getName() to get the name of the rule
        return "Skills"; //in this case, "skills" rule are being returned.
    }

    @Override
    public double getWeight() 
    { return 0.50;  //returns the weight of the skill rule

    }

    @Override
    public double score(Applicant applicant, JobPosting job) { //receives the applicant and JobPosting Objects
        List<String> required = Keywords.csv(job.getRequiredSkills()); //retrieves requiredskills from the JobPosting.java
        List<String> owned = applicant.getSkillList(); //assigning the skills of the Applicant.java to"owned" variable
        if (required.isEmpty()){
             return 0; //no required skills means no score
        }
        int matched = 0;
        for (String skill : required) {
            if (owned.contains(skill)) matched++;
        }
        return 100.0 * matched / required.size();
    }
}
