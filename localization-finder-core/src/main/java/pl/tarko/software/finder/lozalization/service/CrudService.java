package pl.tarko.software.finder.lozalization.service;

import java.io.Serializable;

public interface CrudService<T, ID extends Serializable> {
    <S extends T> void save(S entity);

    void delete(ID id);
}