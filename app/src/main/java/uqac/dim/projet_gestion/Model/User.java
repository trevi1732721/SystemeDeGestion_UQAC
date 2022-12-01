package uqac.dim.projet_gestion.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.*;

public class User implements Parcelable {

    private String id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private String role;
    private String note;
    private List<Task> tasks;
    private List<Task> completedTasks;
    private Set<String> createdProjects;
    private Set<String> projectsTakePartIn;

    private long registerDate;

    /**
     * CREATOR to implement Parcelable
     */
    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public User(String userName, String name, String email, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.createdProjects = new HashSet<>();
        this.projectsTakePartIn = new HashSet<>();
        this.registerDate = new Date().getTime();
        this.role = "User";
        this.note = "";
    }

    public void removeProject(String projectName) {
        projectsTakePartIn.remove(projectName);
        createdProjects.remove(projectName);
    }

    /*public boolean isRoleAdmin() {
        return role.equals("Admin");
    }*/

    /*public boolean isMember(Project project) {
        return project.getMembers().contains(userName);
    }*/

    /*public boolean isProjectAdmin(Project project) {
        return project.getAdmins().contains(userName);
    }*/

    /*public Task findTaskByKey(String key) {
        return tasks.stream()
                .filter(task -> task.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }*/

    /*public void deleteTaskByKey(String key) {
        tasks.removeIf(task -> task.getKey().equals(key));
    }*/
}