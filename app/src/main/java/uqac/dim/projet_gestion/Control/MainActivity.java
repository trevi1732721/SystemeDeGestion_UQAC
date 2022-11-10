package uqac.dim.projet_gestion.Control;

import androidx.appcompat.app.AppCompatActivity;
import uqac.dim.projet_gestion.Model.*;

import android.os.Bundle;
import android.view.View;

import uqac.dim.projet_gestion.R;

public class MainActivity extends AppCompatActivity {

    Project project1;
    User user1;
    Task task1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void addemploye(View view)        // on peut tu les renommer addEmploye  ????? pls
    {
        User user = new User("Username", "nom", "email", "Password");
        user1 = user;
    }

    protected void addtask(View view)           // on peut tu les renommer addTask  ????? pls
    {
        Task task = new Task("nomDeTache","Voici la nouvelle tâche", 25, "7 janvier");
        task1 = task;
    }

    protected void addproject(View view)        // on peut tu les renommer addProject  ????? pls
    {
        Project project = new Project("nomDeProjet", "NomAuteur");
        project1 = project;
    }

    protected void list_employes(View view)
    {
        //vas dans la bd

        //extrait les employers

        //affiche les infos des employées

        if (user1.getName() != null){ // vérifie si l'élement a bien été créé
            user1.printUser();        // print le user en console
        }

    }

    protected void list_tasks(View view)
    {

        //vas dans la bd

        //extrait les tâches

        //affiche les infos des tâches

        if (task1.getName() != null){       // vérifie si l'élement a bien été créé
            task1.printTask();              // print le user en console
        }

    }

    protected void list_projects(View view)
    {
        //vas dans la bd

        //extrait les Projets

        //affiche les infos des projets

        if (project1.getName() != null){   // vérifie si l'élement a bien été créé
            project1.afficherProjet();     // print le user en console
        }

    }
}