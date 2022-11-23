package uqac.dim.projet_gestion.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class Project {

    private String id;
    private String name;
    private String projectKey;
    private String authorName;
    private List<String> members;
    private List<String> admins;
    private List<Task> projectTasks;
    private List<Task> completedTasks;
    private List<ProjectItem> activeProjectItems;
    private List<ProjectItem> doneProjectItems;


    public Project(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
        this.projectTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.activeProjectItems = new ArrayList<>();
        this.doneProjectItems = new ArrayList<>();
        this.projectKey = generateKey();
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

    // Generer une cle pour le projet
    private String generateKey() {
        return UUID.randomUUID().toString();
    }

    // Ajouter un projet dans une des liste (projets actifs ou projets finis)
    public void addItem(ProjectItem projectItem, String listName) {
        switch (listName) {
            case "current":
                activeProjectItems.add(projectItem);
                break;
            case "done":
                doneProjectItems.add(projectItem);
                break;
        }
    }

    // Mettre tous les projets comme finis
    public void markAllCurrentItemsAsDone() {
        doneProjectItems.addAll(activeProjectItems);
        activeProjectItems.clear();
    }

    // Retirer un projet de la liste
    public void removeCard(ProjectItem projectItem) {
        activeProjectItems.remove(projectItem);
        doneProjectItems.remove(projectItem);
    }

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