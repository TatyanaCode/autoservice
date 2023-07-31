package services;

import java.util.List;

public interface AbstractService<T> {
    List<T> getAll(String token);

    boolean insert(String token, T body);

    boolean delete(String token, Long id);

    boolean updateById(String token, Long id, T body);

}
