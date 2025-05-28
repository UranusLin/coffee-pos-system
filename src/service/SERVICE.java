package service;

import java.util.List;

public interface SERVICE<T> {
    boolean insert(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(int id) throws Exception;
    T get(int id) throws Exception;
    List<T> getAll() throws Exception;
    boolean exportCSV() throws Exception;
}
