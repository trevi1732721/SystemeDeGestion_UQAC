package uqac.dim.projet_gestion.Model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;                         //nom de la tâche
    private String description;                  //description de la tâche
    private float estimedHours;                  //Nombre d'heures estimer de la tâche
    private float realHours;                     //Nombre d'heures réél de la tâche en cour ou terminer.
    private String state;                        // defini l"état de la tâche                                // Pourrait devenir un enum...
    private String deadline;                     //date maximal de completion de la tâche


    public Task(String name, String description, float estimedHours, String deadline){
        this.name = name;
        this.description = description;
        this.estimedHours = estimedHours;
        realHours = 0;
        state = "En attente";
        this.deadline =  deadline;

    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        deadline = deadline;
    }

    private List<Task> tasks = new ArrayList<Task>(); //contient d'autre tâches (sous tâches a effectuées)      // pourrait etre n'importe quel type de liste ou de tableau // récursivité, il y a des tâches dans une tâches

    public String getName() {                                                                     //
        return name;                                                                             //
    }                                                                                            //
                                                                                                 //
    public void setName(String name) {                                                             //
        this.name = name;                                                                        //
    }                                                                                            //
                                                                                                 //
    public String getDescription() {                                                             //
        return description;                                                                      //
    }                                                                                            //
                                                                                                 //
    public void setDescription(String description) {                                             //
        this.description = description;                                                          // Getters and setters
    }                                                                                            //
                                                                                                 //
    public float getNbHeureEstimer() {                                                           //
        return estimedHours;                                                                     //
    }                                                                                            //
                                                                                                 //
    public void setNbHeureEstimer(float nbHeureEstimer) {                                        //
        this.estimedHours = estimedHours;                                                        //
    }                                                                                            //
                                                                                                 //
    public float getNbHeureReel() {                                                              //
        return realHours;                                                                        //
    }                                                                                            //
                                                                                                 //
    public void setNbHeureReel(float realHours) {                                                //
        this.realHours = realHours;                                                              //
    }                                                                                            //
                                                                                                 //
    public String getEtat() {                                                                    //
        return state;                                                                            //
    }                                                                                            //
                                                                                                 //
    public void setEtat(String etat) {                                                           //
        this.state = state;                                                                      //
    }                                                                                            //
                                                                                                 //
    public List<Task> getTasks() {                                                               //
        return tasks;                                                                            //
    }                                                                                            //
                                                                                                 //
    public void setTasks(List<Task> tasks) {                                                     //
        this.tasks = tasks;                                                                      //
    }                                                                                            //

    public void printTask(){
        System.out.println( name + " " + description + " " + estimedHours + " " + realHours + " " + state + " " + deadline);
    }

}
