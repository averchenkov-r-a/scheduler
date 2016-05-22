package ru.devjava.averchenkov.springrest.scheduler.model.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Parent;

/**
 * @author Averchenkov R.A.
 */
public interface ParentRepositories extends CrudRepository<Parent, Integer> {}
