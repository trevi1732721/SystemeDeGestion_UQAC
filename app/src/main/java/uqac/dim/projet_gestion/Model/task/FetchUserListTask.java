package uqac.dim.projet_gestion.Model.task;

import android.os.AsyncTask;
import uqac.dim.projet_gestion.database.repository.GestionRepository;
import uqac.dim.projet_gestion.database.repository.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class FetchUserListTask extends AsyncTask<String, Void, List> {
    public static final String USER_BY_ID = "ID";
    public static final String USER_BY_LAST_NAME = "LAST_NAME";
    public static String lastSearchedCriteria;

    private final FetchUserListListener listener;
    private final GestionRepository gestionRepository;


    public FetchUserListTask(FetchUserListListener listener, GestionRepository gestionRepository) {
        this.listener = listener;
        this.gestionRepository = gestionRepository;
    }

    @Override
    protected void onPreExecute() {
        listener.onUserListFetching();
    }

    @Override
    protected List doInBackground(String... strings) {
        lastSearchedCriteria = strings[0];

        List users;

        //default is used as the type category since nothing else could be sent
        try {
            switch (strings[0]) {
                case USER_BY_ID:
                    users = gestionRepository.findAllbyUserId();
                    break;
                case USER_BY_LAST_NAME:
                    users = gestionRepository.findAllbyLastName();
                    break;
                default:
                    users = gestionRepository.findAll();
                    break;
            }

        } catch (RepositoryException repositoryException) {
            users = new ArrayList<>();
        }

        return users;
    }

    @Override
    protected void onPostExecute(List users) {
        listener.onUserListFetched(users);
    }

    /**
     * Interface to communicate information and state from this task with MainActivity
     *
     *
     *
     */
    public interface FetchUserListListener {

        /**
         * Function used to notify MainActivity of the beginning of FetchPokemonListTask
         *
         * @see FetchUserListTask
         */
        void onUserListFetching();

        void onUserListFetched(List users);
    }


}
