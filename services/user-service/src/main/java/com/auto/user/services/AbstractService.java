package com.auto.user.services;

import java.util.List;

/**
 * author danilova.tatyana 31.07.2023
 */
public interface AbstractService<T> {
    List<T> getAll();
    boolean update(T body);
    boolean updateById(Long id);
    boolean delete(Long id);
    boolean insert(T body);
}
