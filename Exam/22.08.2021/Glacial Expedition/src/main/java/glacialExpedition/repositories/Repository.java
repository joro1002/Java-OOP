package glacialExpedition.repositories;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {
    List<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
