package dsalgo.utilities;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraIntegration {

	static Dotenv dotenv = Dotenv.load();
	private static final String JIRA_URL = dotenv.get("JIRA_URL");
	private static final String JIRA_USERNAME = dotenv.get("JIRA_USERNAME");
	private static final String JIRA_PASSWORD = dotenv.get("JIRA_PASSWORD");

	// ✅ 1. Create new issue
	public static void createJiraIssue(String projectKey, String summary, String screenshotPath, String status,
		 String failureMessage, String testName) {

		JsonObject payload = new JsonObject();
		JsonObject fields = new JsonObject();
		JsonObject project = new JsonObject();
		JsonObject issueTypeJson = new JsonObject();

// Set project key and issue type (Task for passed, Bug for failed)
		project.addProperty("key", projectKey);
		String issueType = status.equalsIgnoreCase("PASSED") ? "Task" : "Bug";
		issueTypeJson.addProperty("name", issueType);

		fields.add("project", project);
		fields.add("issuetype", issueTypeJson);
		fields.addProperty("summary", summary);

// Construct Atlassian Document Format for the description
		JsonObject description = new JsonObject();
		description.addProperty("type", "doc");
		description.addProperty("version", 1);

		JsonArray contentArray = new JsonArray();
		JsonObject paragraph = new JsonObject();
		paragraph.addProperty("type", "paragraph");

		JsonArray paragraphContent = new JsonArray();
		JsonObject textContent = new JsonObject();
		textContent.addProperty("type", "text");

		StringBuilder sb = new StringBuilder();
		sb.append("Test Case: ").append(testName).append("\n").append("Status: ").append(status);

		if (!"PASSED".equalsIgnoreCase(status) && failureMessage != null) {
			sb.append("\nFailure: ").append(failureMessage);
		}

		textContent.addProperty("text", sb.toString());
		paragraphContent.add(textContent);
		paragraph.add("content", paragraphContent);
		contentArray.add(paragraph);
		description.add("content", contentArray);

		fields.add("description", description);
		payload.add("fields", fields);

		Response response = RestAssured.given().auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
				.header("Content-Type", "application/json").body(payload.toString()).log().all().post(JIRA_URL);

		if (response.statusCode() == 201) {
			String issueKey = response.jsonPath().get("key");
			System.out.println("✅ Jira issue created successfully: " + issueKey);

			if (screenshotPath != null) {
				attachScreenshot(issueKey, screenshotPath);
			}
		} else {
			System.err.println("❌ Failed to create Jira issue: " + response.body().asString());
		}
	}
    
   // ✅ Get Issue Details by Test Name (summary)
    public static String getIssueBySummary(String projectKey, String testName) {
        String searchUrl = "https://rkbevit.atlassian.net/rest/api/3/search";
        String jql = "project=" + projectKey + " AND summary ~ \"" + testName + "\" AND status != Closed";

        Response response = RestAssured
            .given()
            .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
            .header("Content-Type", "application/json")
            .queryParam("jql", jql)
            .get(searchUrl);

        if (response.statusCode() == 200) {
            List<Map<String, Object>> issues = response.jsonPath().getList("issues");
            if (!issues.isEmpty()) {
                return (String) issues.get(0).get("key");
            }
        } else {
            System.err.println("❌ Get issue failed: " + response.body().asString());
        }

        return null;
    }

 // ✅ Update Jira Issue (add comment + optional type)
    public static void updateIssue(String issueKey, String commentText, String issueType,String screenshotPath) {
        // Optional: update issue type
        if (issueType != null) {
            JsonObject updatePayload = new JsonObject();
            JsonObject fields = new JsonObject();
            JsonObject issueTypeJson = new JsonObject();
            issueTypeJson.addProperty("name", issueType);
            fields.add("issuetype", issueTypeJson);
            updatePayload.add("fields", fields);

            Response updateResp = RestAssured
                .given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .header("Content-Type", "application/json")
                .body(updatePayload.toString())
                .put(JIRA_URL + "/" + issueKey);

            if (updateResp.statusCode() == 204) {
                System.out.println("🛠️ Issue type updated to: " + issueType);
            } else {
                System.err.println("❌ Issue type update failed: " + updateResp.body().asString());
            }
        }

     // Build ADF-compliant comment body
        JsonObject commentBody = new JsonObject();
        commentBody.addProperty("type", "doc");
        commentBody.addProperty("version", 1);

        JsonArray content = new JsonArray();
        JsonObject paragraph = new JsonObject();
        paragraph.addProperty("type", "paragraph");

        JsonArray paragraphContent = new JsonArray();
        JsonObject text = new JsonObject();
        text.addProperty("type", "text");
        text.addProperty("text", commentText);  // Use your actual comment text here

        paragraphContent.add(text);
        paragraph.add("content", paragraphContent);
        content.add(paragraph);
        commentBody.add("content", content);

        JsonObject finalPayload = new JsonObject();
        finalPayload.add("body", commentBody);

        // POST comment to Jira
        Response commentResp = RestAssured
                .given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .header("Content-Type", "application/json")
                .body(finalPayload.toString())
                .post(JIRA_URL + "/" + issueKey + "/comment");

        if (commentResp.statusCode() == 201) {
            System.out.println("✅ Comment added to issue: " + issueKey);
            if (screenshotPath != null) {
                attachScreenshot(issueKey, screenshotPath);
            }
        } else {
            System.err.println("❌ Comment failed: " + commentResp.body().asString());
        }
    }

    // ✅ 3. Attach screenshot
    public static void attachScreenshot(String issueKey, String screenshotPath) {
        File file = new File(screenshotPath);

        Response response = RestAssured
            .given()
            .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
            .header("X-Atlassian-Token", "no-check")
            .multiPart("file", file)
            .log().all()
            .post(JIRA_URL + "/" + issueKey + "/attachments");

        if (response.statusCode() == 200) {
            System.out.println("Screenshot attached to: " + issueKey);
        } else {
            System.err.println(" Screenshot failed: " + response.body().asString());
        }
    }
}

