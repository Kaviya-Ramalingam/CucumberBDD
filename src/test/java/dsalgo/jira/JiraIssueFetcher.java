package dsalgo.jira;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraIssueFetcher {

    private final JiraCredential jiraCredential;

    public JiraIssueFetcher(JiraCredential jiraCredential) {
        this.jiraCredential = jiraCredential;
    }

    public String getIssueBySummary(String projectKey, String summary) {
        String searchUrl = jiraCredential.getJiraUrl();
        String jql = String.format("project=%s AND summary ~ \"%s\" AND status != Closed", projectKey, summary);

        Response response = RestAssured
                .given()
                .auth().preemptive().basic(jiraCredential.getJiraUsername(), jiraCredential.getJiraPassword())
                .header("Content-Type", "application/json")
                .queryParam("jql", jql)
                .get(searchUrl);

        if (response.statusCode() == 200) {
            List<Map<String, Object>> issues = response.jsonPath().getList("issues");
            if (issues != null && !issues.isEmpty()) {
                return (String) issues.get(0).get("key");
            }
        } else {
            System.err.println("Failed to fetch issue: " + response.body().asString());
        }
        return null;
    }
}

