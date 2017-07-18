package interfaces;

import java.util.List;

public interface IntGenericDao<E,K> {
    void delete(K id);
    void insert(E model);
    void update(E model);
    List<E> getAllModel();
    E getModelById(K id);
}
