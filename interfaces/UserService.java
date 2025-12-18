package interfaces;

import java.util.List;

public interface UserService<T> {
    T create(T user);
    T update(String id, T user);
    boolean delete(String id);
    List<T> findAll();
    T findOne(String id);
}
