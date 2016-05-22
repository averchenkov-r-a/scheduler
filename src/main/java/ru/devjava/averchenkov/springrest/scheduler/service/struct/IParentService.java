package ru.devjava.averchenkov.springrest.scheduler.service.struct;

import ru.devjava.averchenkov.springrest.scheduler.model.entity.Parent;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface IParentService {
    List<Parent> getAll();

    Parent getById(Integer id);

    Parent save(Parent child);

    void delete(Integer id);
}
