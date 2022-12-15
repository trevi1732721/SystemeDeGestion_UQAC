package uqac.dim.projet_gestion.Control;

import uqac.dim.projet_gestion.Model.Project;

public class ProjectController extends Controller {
    public void createProject(){

        // l'utilisateur entre les informations requises.
        String cin = "";
        testEntry(cin);
        // répété pour toutes les info necessaires.

        Project projet = new Project("Projet 1", "Jean Chrétien");
    };
}
