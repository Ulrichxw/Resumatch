import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class GeminiClient {

    private final String apiKey = System.getenv("GEMINI_API_KEY");
    private final String model = System.getenv().getOrDefault("GEMINI_MODEL", "gemini-3.5-flash-lite");
    private final HttpClient http = HttpClient.newHttpClient();

        public String writeResume(Applicant applicant, JobPosting job) throws Exception {
        System.out.println("Calling Gemini with model: " + model);
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("The Gemini key is missing. Set the GEMINI_API_KEY environment variable and restart the server.");
        }

        String body = "{\"contents\":[{\"parts\":[{\"text\":" + Json.quote(buildPrompt(applicant, job)) + "}]}]}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/" + model + ":generateContent"))
                .header("Content-Type", "application/json")
                .header("x-goog-api-key", apiKey)
                .timeout(Duration.ofSeconds(90))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
    throw new IllegalStateException(
        "Gemini returned error " + response.statusCode() + ": " + response.body()
    );
}
        return Json.firstText(response.body()).replace("```", "").trim();
    }

    /** The instructions we send. The strict rules stop Gemini from inventing facts. */
    private String buildPrompt(Applicant a, JobPosting job) {
        return """
You are an ATS resume writer. Turn the APPLICANT data into a polished one-page resume tailored to the JOB. Rewrite the applicant's raw notes into professional resume language. Do not copy them word for word, and do not invent anything.

FACTS VS WORDING
- FACTS are employers, job titles, dates, schools, degrees, skills, tools, certifications, projects, responsibilities and results. Every fact MUST come from APPLICANT. NEVER add a new fact.
- WORDING is everything else. You MUST improve it:
  - Turn fragments and rough notes into complete, formal sentences.
  - Start every work and project bullet with a strong action verb.
  - Add short supporting phrases that state the purpose, scope or relevance of a fact the applicant gave, when it follows directly from what they wrote.
  - Use the JOB's own keywords where the applicant's facts match them, so ATS software can find them. NEVER claim a keyword the applicant did not provide.
- NEVER add numbers, metrics, results, team sizes, tools, dates, employers, responsibilities or years of experience that are not in APPLICANT. If an achievement has no number, describe it without one.
- Keep names, job titles, dates, school names and technical terms exactly as given. Reword everything else.
- Before writing each sentence, ask: "Which APPLICANT field supports every fact in this sentence?" If you cannot name one, delete the sentence.
- If a field is blank or very short, write less for it. Never pad it.

JOB
Title: %s
Company: %s
Description: %s
Qualifications: %s
Required skills: %s

APPLICANT
Name: %s
Email: %s
Summary: %s
Education: %s
Skills: %s
Work experience: %s
Certifications: %s
Projects: %s

OUTPUT FORMAT
- Plain text only. No Markdown symbols, tables, columns or special characters. Use CAPITAL LETTERS for section headings and a dash "-" for bullets.
- Start with the applicant's name and email. Then write a PROFESSIONAL SUMMARY of 2 to 3 sentences built only from the applicant's facts and the job's focus.
- Then add these sections, ordered by relevance to the job: SKILLS, WORK EXPERIENCE, PROJECTS, EDUCATION, CERTIFICATIONS. Skip any section with no data.
- List the most job-relevant skills and experience first. Group related skills on one line.
- Use 2 to 4 bullets per job or project. Each bullet is one complete sentence of 12 to 25 words.
- Keep the whole resume to one page, about 450 to 550 words at most.
- Reply with the resume only. No notes, no explanations.

EXAMPLE (style only, never reuse its content)
Applicant note: "worked at cafe, took orders, handled cash, 2021-2022"
Too literal (wrong):
- Took orders
- Handled cash
Invented (wrong):
- Increased sales by 20 percent during peak hours
Correct:
- Took customer orders and processed cash payments, providing direct customer service at a cafe.
                """.formatted(
                job.getTitle(), job.getEmployer().getCompanyName(), job.getDescription(),
                job.getQualifications(), job.getRequiredSkills(),
                a.getName(), a.getEmail(), a.getSummary(), a.getDegree(), a.getSkills(),
                a.getExperience(), a.getCertifications(), a.getProjects());
    }
}
