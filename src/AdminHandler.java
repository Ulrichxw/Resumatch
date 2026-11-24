import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** The admin approves or rejects job postings. The admin cannot edit them. */
public class AdminHandler extends ApiHandler {

    public AdminHandler(DataStore store, SessionManager sessions) {
        super(store, sessions);
    }

    @Override
    protected Class<? extends User> requiredUser() { return Admin.class; }

    @Override
    protected Object respond(Request request) {
        switch (request.action()) {
            case "pending":
                List<Map<String, Object>> list = new ArrayList<>();
                for (JobPosting job : store.jobsWithStatus(JobPosting.Status.PENDING)) list.add(describe(job));
                return list;
            case "decide":
                JobPosting job = store.findJob(request.number("jobId"));
                if (request.text("decision").equals("approve")) job.approve();
                else if (request.text("decision").equals("reject")) job.reject();
                else throw new IllegalArgumentException("Choose approve or reject.");
                return Map.of("ok", true);
            default: throw new IllegalArgumentException("Unknown action.");
        }
    }
}
