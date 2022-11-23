package uqac.dim.projet_gestion;

import java.util.ArrayList;
import java.util.List;


public class Project {

    private String id;
    private String name;
    private String projectKey;
    private String authorName;
    private List<String> members;
    private List<String> admins;
    private List<Task> projectTasks;
    private List<Task> completedTasks;


    public Project(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
        this.projectTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
    }

    // Recuperer la tache correspondante a la cle
    /*public Task getTaskByKey(String key) {
        return projectTasks.stream()
                .filter(task -> task.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }*/

    // Retirer la tache correspondante a la cle
    /*public void removeTaskByKey(String key) {
        projectTasks.removeIf(task -> task.getKey().equals(key));
    }*/


    // Recuperer un projet a partir de sa cle correspondante
    /*public ProjectItem getItemByKey(String key) {
        // we try to find an item in the first list - 'doneProjectItems'
        Optional<ProjectItem> doneItem = doneProjectItems.stream()
                .filter(item -> item.getKey().equals(key))
                .findFirst();

        // If there is no such item, then it is in the second
        Optional<ProjectItem> activeItem = activeProjectItems.stream()
                .filter(item -> item.getKey().equals(key))
                .findFirst();

        return doneItem.orElseGet(activeItem::get);
    }*/
}