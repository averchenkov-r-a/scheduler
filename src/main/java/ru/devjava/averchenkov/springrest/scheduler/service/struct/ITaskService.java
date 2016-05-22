package ru.devjava.averchenkov.springrest.scheduler.service.struct;

import ru.devjava.averchenkov.springrest.scheduler.model.entity.Task;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface ITaskService {
    List<Task> getAll();

    Task getById(Integer id);

    List<Task> getTasksByChildId(Integer childId);

    Task save(Task child);

    void delete(Integer id);
}
