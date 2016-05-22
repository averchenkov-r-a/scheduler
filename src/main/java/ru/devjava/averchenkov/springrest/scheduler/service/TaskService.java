package ru.devjava.averchenkov.springrest.scheduler.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Task;
import ru.devjava.averchenkov.springrest.scheduler.model.repositories.TaskRepositories;
import ru.devjava.averchenkov.springrest.scheduler.service.struct.ITaskService;

import java.util.List;

/**
 * Сервис задач.
 *
 * @author Averchenkov R.A.
 */
@Service
public class TaskService implements ITaskService {
    private static Logger logger = LoggerFactory.getLogger(TaskService.class);

    private TaskRepositories taskRepositories;
    @Autowired
    public void setTaskRepositories(TaskRepositories taskRepositories) {
        this.taskRepositories = taskRepositories;
    }

    @Override
    public List<Task> getAll(){
        logger.debug("Call method getAll in the class TaskService.");
        return Lists.newArrayList(taskRepositories.findAll());
    }

    @Override
    public Task getById(Integer id){
        logger.debug("Call method getById in the class TaskService.");
        return taskRepositories.findOne(id);
    }

    @Override
    public List<Task> getTasksByChildId(Integer childId){
        logger.debug("Call method getTasksByChildId in the class TaskService.");
        return taskRepositories.findTasks(childId);
    }

    @Override
    public Task save(Task child){
        logger.debug("Call method save in the class TaskService.");
        return taskRepositories.save(child);
    }

    @Override
    public void delete(Integer id){
        logger.debug("Call method delete in the class TaskService.");
        taskRepositories.delete(id);
    }
}
