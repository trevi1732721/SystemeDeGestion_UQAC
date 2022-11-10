package uqac.dim.projet_gestion;

import java.util.*;

public class Project {

    private String id;

    private String name;
    //private String projectKey;
    private String nomAuteur;
    //private String currencySign;

    private List<String> membres;
    private List<String> administrateurs;
    private List<Task> tachesProjet;
    private List<Task> tachesComplete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public List<String> getMembres() {
        return membres;
    }

    public void setMembres(List<String> membres) {
        this.membres = membres;
    }

    public List<String> getAdministrateurs() {
        return administrateurs;
    }

    public void setAdministrateurs(List<String> administrateurs) {
        this.administrateurs = administrateurs;
    }

    public List<Task> getTachesProjet() {
        return tachesProjet;
    }

    public void setTachesProjet(List<Task> tachesProjet) {
        this.tachesProjet = tachesProjet;
    }

    public List<Task> getTachesComplete() {
        return tachesComplete;
    }

    public void setTachesComplete(List<Task> tachesComplete) {
        this.tachesComplete = tachesComplete;
    }

    public Project(String nom, String nomAuteur)
    {
        this.name = name;
        this.nomAuteur = nomAuteur;

        this.administrateurs = new ArrayList<>();
        this.membres = new ArrayList<>();
        this.tachesProjet = new ArrayList<>();
        this.tachesComplete = new ArrayList<>();
    }

    public Task getTask ()
    {
        return tachesProjet.stream().findFirst().orElse(null);
    }

    public void afficherProjet(){
        System.out.println(name + " " + nomAuteur + " " + membres +  " " + administrateurs +  " " + tachesProjet +  " " + tachesComplete );
    }
}