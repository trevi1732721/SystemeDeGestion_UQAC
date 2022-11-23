package uqac.dim.projet_gestion.Model;

import java.util.UUID;


public class ProjectItem {

    private String text;
    private String projectName;
    private String key;

    public ProjectItem(String text, String projectName) {
        this.text = text;
        this.projectName = projectName;
        this.key = generateKey();
    }

    private String generateKey() {
        return UUID.randomUUID().toString();
    }
}