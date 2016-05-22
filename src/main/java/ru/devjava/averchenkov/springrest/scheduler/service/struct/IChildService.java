package ru.devjava.averchenkov.springrest.scheduler.service.struct;

import ru.devjava.averchenkov.springrest.scheduler.model.entity.Child;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface IChildService {
    List<Child> getAll();

    Child getById(Integer id);

    List<Child> getChildsByParentId(Integer parentId);

    Child save(Child child);

    void delete(Integer id);
}
