package ru.devjava.averchenkov.springrest.scheduler.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Child;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface ChildRepositories extends CrudRepository<Child, Integer> {
    @Query(value = "select * from scheduler.child where pr_id = ?1", nativeQuery = true)
    List<Child> findChilds(Integer parentId);
}
