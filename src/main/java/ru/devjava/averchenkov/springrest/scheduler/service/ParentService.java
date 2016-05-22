package ru.devjava.averchenkov.springrest.scheduler.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Parent;
import ru.devjava.averchenkov.springrest.scheduler.model.repositories.ParentRepositories;

import java.util.List;

/**
 * Сервис родителей.
 *
 * @author Averchenkov R.A.
 */
@Service
public class ParentService implements ru.devjava.averchenkov.springrest.scheduler.service.struct.IParentService {
    private static Logger logger = LoggerFactory.getLogger(ParentService.class);

    private ParentRepositories parentRepositories;
    @Autowired
    public void setParentRepositories(ParentRepositories parentRepositories) {
        this.parentRepositories = parentRepositories;
    }

    @Override
    public List<Parent> getAll(){
        logger.debug("Call method getAll in the class ParentService.");
        return Lists.newArrayList(parentRepositories.findAll());
    }

    @Override
    public Parent getById(Integer id){
        logger.debug("Call method getById in the class ParentService.");
        return parentRepositories.findOne(id);
    }

    @Override
    public Parent save(Parent child){
        logger.debug("Call method save in the class ParentService.");
        return parentRepositories.save(child);
    }

    @Override
    public void delete(Integer id){
        logger.debug("Call method delete in the class ParentService.");
        parentRepositories.delete(id);
    }
}
