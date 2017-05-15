package pl.tarko.software.finder.localization.service.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import pl.tarko.software.finder.localization.service.CrudService;

import java.io.Serializable;

public class CrudServiceImpl<TO, T, ID extends Serializable> implements CrudService<T, ID> {

    @Autowired
    protected CrudRepository<T, ID> repository;

    @Autowired
    protected MapperFacade mapper;

    @Override
    public <S extends T> void save(S entity) {
        repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

}