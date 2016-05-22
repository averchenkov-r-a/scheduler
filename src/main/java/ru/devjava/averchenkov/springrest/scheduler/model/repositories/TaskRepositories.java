package ru.devjava.averchenkov.springrest.scheduler.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Task;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface TaskRepositories extends CrudRepository<Task, Integer> {
    @Query(value = "select * from scheduler.task where ch_id = ?1", nativeQuery = true)
    List<Task> findTasks(Integer childId);
}
