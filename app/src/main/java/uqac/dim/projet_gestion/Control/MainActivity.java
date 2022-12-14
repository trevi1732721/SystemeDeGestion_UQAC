package uqac.dim.projet_gestion.Control;

import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import uqac.dim.projet_gestion.Model.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import uqac.dim.projet_gestion.Model.task.FetchUserListTask;
import uqac.dim.projet_gestion.R;
import uqac.dim.projet_gestion.database.repository.GestionRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements FetchUserListTask.FetchUserListListener{

    private GestionRepository gestionRepository;
    private ProgressBar navigationViewProgressBar;
    Project project1;
    User user1;
    Task task1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Button employe = (Button) findViewById(R.id.addEmploye);
        employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmploye(view);
            }
        });
        /*Button task = (Button) findViewById(R.id.addTask);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask(view);
            }
        });*/
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
        /*Button listTask = (Button) findViewById(R.id.listTask);
        listTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_tasks(view);
            }
        });*/
        Button listProject = (Button) findViewById(R.id.listProject);
        listProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_projects(view);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    protected void addEmploye(View view)
    {
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_add_employe, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        Button cancel = (Button) popupView.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel button
                popupWindow.dismiss();
            }
        });

        Button save = (Button) popupView.findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String firstName = ((EditText) findViewById(R.id.firstName)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.lastName)).getText().toString();
                String utilisateur = ((EditText) findViewById(R.id.utilisateur)).getText().toString();
                String email = ((EditText) findViewById(R.id.email)).getText().toString();
                String qualification = ((EditText) findViewById(R.id.qualification)).getText().toString();
                String mdp = ((EditText) findViewById(R.id.mdp)).getText().toString();*/
                popupWindow.dismiss();
            }
        });
    }

    /*protected void addTask(View view)
    {
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_add_task, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        Button cancel = (Button) popupView.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel button
                popupWindow.dismiss();
            }
        });
        Button save = (Button) popupView.findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String description = ((EditText) findViewById(R.id.description)).getText().toString();
                String tempsEstimer = ((EditText) findViewById(R.id.tempsEstimer)).getText().toString();
            }
        });
    }*/

    protected void addProject(View view)
    {
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_add_project, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        Button cancel = (Button) popupView.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel button
                popupWindow.dismiss();
            }
        });
        Button save = (Button) popupView.findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String title = ((EditText) findViewById(R.id.title)).getText().toString();
                //String description = ((EditText) findViewById(R.id.description)).getText().toString();
                //String fileNumber = ((EditText) findViewById(R.id.fileNumber)).getText().toString();
                popupWindow.dismiss();
            }
        });
    }


    public void makeFetchUserListDbRequest(String fetchCriteria) {
        FetchUserListTask fetchListTask = new FetchUserListTask(this, gestionRepository);
        fetchListTask.execute(fetchCriteria);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.listEmploye:
                makeFetchUserListDbRequest(FetchUserListTask.USER_BY_ID);
                break;
            default:
                break;
        }
        item.setChecked(true);
        return super.onOptionsItemSelected(item);
    }

    public GestionRepository getGestionRepository() {
        return gestionRepository;
    }

    private void showFullscreenProgressBar() {
        navigationViewProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideFullscreenProgressBar() {
        navigationViewProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onUserListFetching() {
        showFullscreenProgressBar();
    }

    @Override
    public void onUserListFetched(List users) {
        hideFullscreenProgressBar();
        //réception de la liste d'user qui ont les critères demandées.
    }
    protected void list_employes(View view)
    {
        Intent list_employes = new Intent(MainActivity.this,listEmployes.class);
        startActivity(list_employes);
        //vas dans la bd

        //extrait les employers

        //affiche les infos des employées

        /*if (user1.getName() != null){ // vérifie si l'élement a bien été créé
            user1.printUser();        // print le user en console
        }*/

    }

    /*protected void list_tasks(View view)
    {
        Intent list_tasks = new Intent(MainActivity.this,listTasks.class);
        startActivity(list_tasks);
        //vas dans la bd

        //extrait les tâches

        //affiche les infos des tâches

        /*if (task1.getName() != null){       // vérifie si l'élement a bien été créé
            task1.printTask();              // print le user en console
        }*/

    //}

    protected void list_projects(View view)
    {
        Intent list_projects = new Intent(MainActivity.this,listProjects.class);
        startActivity(list_projects);
        //vas dans la bd

        //extrait les Projets

        //affiche les infos des projets

        /*if (project1.getName() != null){   // vérifie si l'élement a bien été créé
            project1.afficherProjet();     // print le user en console
        }*/

    }
}