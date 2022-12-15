package uqac.dim.projet_gestion.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private float maxHours;

    private String workstation;

    private String qualification;

    private int access;

    /*private String role;
    private String userName;
    private String note;
    private List<Task> tasks;
    private List<Task> completedTasks;
    private Set<String> createdProjects;
    private Set<String> projectsTakePartIn;

    private long registerDate;
    */

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeFloat(maxHours);
        parcel.writeString(workstation);
        parcel.writeString(qualification);
        parcel.writeInt(access);



       /* if (typeSecondary != null)
            parcel.writeString(typeSecondary.name());
        else
            parcel.writeString(null);

         parcel.writeInt(isFavorite ? 1 : 0);
        */
    }
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

    private User(Parcel parcel){
        this.id = parcel.readInt();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.email = parcel.readString();
        this.maxHours = parcel.readInt();
        this.workstation = parcel.readString();
        this.qualification = parcel.readString();
        this.access = parcel.readInt();

        /*this.tasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.createdProjects = new HashSet<>();
        this.projectsTakePartIn = new HashSet<>();
        this.registerDate = new Date().getTime();
        this.role = "User";
        this.note = "";*/
    }

   /* public User(String userName, String name, String email, String password) {
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
    }*/

    public User(int id, String firstName, String lastName, String email, float maxHours, String workstation, String qualification, int access) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.maxHours = maxHours;
        this.workstation = workstation;
        this.qualification = qualification;
        this.access = access;
    }

   /* public void removeProject(String projectName) {
        projectsTakePartIn.remove(projectName);
        createdProjects.remove(projectName);
    }*/

    @Override
    public int describeContents() {
        return 0;
    }


    public String ToString(){
        return new String ("Id: " + id + " First Name: " + firstName   + " Last Name: " + lastName + " email: " + email +
                " Max Hours: " + maxHours + " Workstation: " + workstation + " Qualification: " + qualification + " Access:" + access);
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