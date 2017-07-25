import java.sql.Connection;
import java.util.List;

public interface IGenericDao<E,K> {
    void birthdate(K id,Connection connection);
    void insert(E entity, Connection connection);
    void update(E entity,Connection connection);
    List<E> getAllEntity(Connection connection);
    E getEntityById(K id,Connection connection);
}