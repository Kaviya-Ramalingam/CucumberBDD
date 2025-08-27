package dsalgo.utilities;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraAuthTest {

    static Dotenv dotenv = Dotenv.load();

    private static final String JIRA_USERNAME = dotenv.get("JIRA_USERNAME");
    private static final String JIRA_PASSWORD = dotenv.get("JIRA_PASSWORD");

    public static void main(String[] args) {

        // Test endpoint to get current user info
        String authTestUrl = "https://rkbevit.atlassian.net/rest/api/3/myself";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .header("Accept", "application/json")
                .get(authTestUrl);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.prettyPrint());

        if (response.statusCode() == 200) {
            System.out.println("✅ Jira API token is working!");
        } else {
            System.err.println("❌ Jira API authentication failed. Check token or username.");
        }
    }
}