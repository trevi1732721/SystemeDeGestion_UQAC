package uqac.dim.projet_gestion.Model;

import java.util.*;

public class User {

    private String id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private String role;

    private List<Task> tasks;

    private long date;

    private Set<String> projetsCreer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Set<String> getProjetsCreer() {
        return projetsCreer;
    }

    public void setProjetsCreer(Set<String> projetsCreer) {
        this.projetsCreer = projetsCreer;
    }

    public List<Task> getTacheComplete() {
        return tacheComplete;
    }

    public void setTacheComplete(List<Task> tacheComplete) {
        this.tacheComplete = tacheComplete;
    }

    private List<Task> tacheComplete;

    public User(String userName, String nom, String email, String password) {
        this.userName = userName;
        this.name = nom;
        this.email = email;
        this.password = password;

        this.tasks = new ArrayList<>();
        this.tacheComplete = new ArrayList<>();

        this.projetsCreer = new HashSet<>();

        this.date = new Date().getTime();
        this.role = "User";
    }

    public void removeProject(String nomProjet) {
        projetsCreer.remove(nomProjet);
    }

    public void printUser(){
        System.out.println(id + " " + userName + " " + name + " " + email + " " + password + " " + role + " " + tasks);
    }
}
