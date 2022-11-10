package uqac.dim.projet_gestion.Control;

import androidx.appcompat.app.AppCompatActivity;
import uqac.dim.projet_gestion.Model.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uqac.dim.projet_gestion.R;

public class MainActivity extends AppCompatActivity {

    Project project1;
    User user1;
    Task task1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button employe = (Button) findViewById(R.id.addEmploye);
        employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmploye(view);
            }
        });
        Button task = (Button) findViewById(R.id.addTask);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask(view);
            }
        });
        Button project = (Button) findViewById(R.id.addProject);
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProject(view);
            }
        });
        Button listEmploye = (Button) findViewById(R.id.listEmploye);
        listEmploye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_employes(view);
            }
        });
        Button listTask = (Button) findViewById(R.id.listTask);
        listTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_tasks(view);
            }
        });
        Button listProject = (Button) findViewById(R.id.listProject);
        listProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_projects(view);
            }
        });
    }

    protected void addEmploye(View view)
    {
        User user = new User("Username", "nom", "email", "Password");
        user1 = user;
    }

    protected void addTask(View view)
    {
        Task task = new Task("nomDeTache","Voici la nouvelle tâche", 25, "7 janvier");
        task1 = task;
    }

    protected void addProject(View view)
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