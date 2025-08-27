package dsalgo.jira;

import io.github.cdimascio.dotenv.Dotenv;

public class JiraCredential {

    private final String jiraUrl;
    private final String jiraUsername;
    private final String jiraPassword;

    public JiraCredential() {
        Dotenv dotenv = Dotenv.load();
        this.jiraUrl = getEnvVar(dotenv, "JIRA_URL");
        this.jiraUsername = getEnvVar(dotenv, "JIRA_USERNAME");
        this.jiraPassword = getEnvVar(dotenv, "JIRA_PASSWORD");
    }

    private String getEnvVar(Dotenv dotenv, String key) {
        String value = dotenv.get(key);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Missing environment variable: " + key);
        }
        return value;
    }

    public String getJiraUrl() {
        return jiraUrl;
    }

    public String getJiraUsername() {
        return jiraUsername;
    }

    public String getJiraPassword() {
        return jiraPassword;
    }
}
