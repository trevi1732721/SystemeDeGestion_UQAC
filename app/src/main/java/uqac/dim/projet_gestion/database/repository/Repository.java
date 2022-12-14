package uqac.dim.projet_gestion.database.repository;
import java.util.List;
public interface Repository<T> {
    List<T> findAll() throws RepositoryException;
}
