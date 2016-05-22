package ru.devjava.averchenkov.springrest.scheduler.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Child;
import ru.devjava.averchenkov.springrest.scheduler.model.repositories.ChildRepositories;
import ru.devjava.averchenkov.springrest.scheduler.service.struct.IChildService;

import java.util.List;

/**
 * Сервис детей.
 *
 * @author Averchenkov R.A.
 */
@Service
public class ChildService implements IChildService {
    private static Logger logger = LoggerFactory.getLogger(ChildService.class);

    private ChildRepositories childRepositories;
    @Autowired
    public void setChildRepositories(ChildRepositories childRepositories) {
        this.childRepositories = childRepositories;
    }

    @Override
    public List<Child> getAll(){
        logger.debug("Call method getAll in the class ChildService.");
        return Lists.newArrayList(childRepositories.findAll());
    }

    @Override
    public Child getById(Integer id){
        logger.debug("Call method getById in the class ChildService.");
        return childRepositories.findOne(id);
    }

    @Override
    public List<Child> getChildsByParentId(Integer parentId){
        logger.debug("Call method getChildsByParentId in the class ChildService.");
        return childRepositories.findChilds(parentId);
    }

    @Override
    public Child save(Child child){
        logger.debug("Call method save in the class ChildService.");
        return childRepositories.save(child);
    }

    @Override
    public void delete(Integer id){
        logger.debug("Call method delete in the class ChildService.");
        childRepositories.delete(id);
    }
}
