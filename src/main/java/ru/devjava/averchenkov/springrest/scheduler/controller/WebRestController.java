package ru.devjava.averchenkov.springrest.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Child;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Parent;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Task;
import ru.devjava.averchenkov.springrest.scheduler.service.ChildService;
import ru.devjava.averchenkov.springrest.scheduler.service.ParentService;
import ru.devjava.averchenkov.springrest.scheduler.service.TaskService;

/**
 * Класс контроллер.
 *
 * @author Averchenkov R.A.
 */
@RestController
public class WebRestController {
    private final String STATUS_SUCCESS = "{status: success}";
    private final String STATUS_ERROR = "{status: error}";

    private ParentService parentService;
    private ChildService childService;
    private TaskService taskService;

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }
    @Autowired
    public void setChildService(ChildService childService) {
        this.childService = childService;
    }
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = {"/", "/home", "/welcome"})
    public String home(){
        return STATUS_SUCCESS;
    }

    /* Parent */

    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    public Object parent(){
        return parentService.getAll();
    }

    @RequestMapping(value = "/parent/{parentId}", method = RequestMethod.GET)
    public Object parentId(@PathVariable String parentId){
        try {
            if (parentId != null){
                Integer id = new Integer(parentId);
                return parentService.getById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_ERROR;
    }

    @RequestMapping(value = "/parent/add", method = RequestMethod.POST)
    public Object addParent(@RequestParam("login")String login,
                            @RequestParam("password")String password,
                            @RequestParam("firstname")String firstName,
                            @RequestParam("lastname")String lastName){
        try {
            Parent parent = new Parent(login, password, firstName, lastName);
            parentService.save(parent);
        } catch (Exception e) {
            e.printStackTrace();
            return STATUS_ERROR;
        }

        return STATUS_SUCCESS;
    }

    @RequestMapping(value = "/parent/delete/{parentId}", method = RequestMethod.DELETE)
    public Object deleteParent(@PathVariable String parentId){
        if (parentId != null){
            Integer id = new Integer(parentId);
            parentService.delete(id);
            return STATUS_SUCCESS;
        }
        return STATUS_ERROR;
    }

    /* Child */

    @RequestMapping(value = "/parent/{parentId}/child", method = RequestMethod.GET)
    public Object child(@PathVariable String parentId){
        try {
            if (parentId != null){
                Integer id = new Integer(parentId);
                return childService.getChildsByParentId(id);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return STATUS_ERROR;
    }

    @RequestMapping(value = "/child/{childId}", method = RequestMethod.GET)
    public Object childId(@PathVariable String childId){
        try {
            if (childId != null){
                Integer id = new Integer(childId);
                return childService.getById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_ERROR;
    }

    @RequestMapping(value = "/child/add/{parentId}", method = RequestMethod.POST)
    public Object addChild(@PathVariable String parentId,
                        @RequestParam("firstname")String firstName,
                        @RequestParam("lastname")String lastName,
                        @RequestParam("productivity")String productivity,
                        @RequestParam("workloyalty")String workloyalty){
        try {
            if (parentId != null){
                Integer id = new Integer(parentId);
                Parent parent = parentService.getById(id);
                Double prd = new Double(productivity);
                Double wlt = new Double(workloyalty);
                Child child = new Child(
                        firstName,
                        lastName,
                        prd,
                        wlt,
                        parent
                );
                return childService.save(child);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return STATUS_SUCCESS;
    }

    @RequestMapping(value = "/child/delete/{childId}", method = RequestMethod.DELETE)
    public Object deleteChild(@PathVariable String childId){
        try {
            if (childId != null){
                Integer id = new Integer(childId);
                childService.delete(id);
                return STATUS_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_ERROR;
    }

    /* Task */

    @RequestMapping(value = "/child/{childId}/task", method = RequestMethod.GET)
    public Object task(@PathVariable String childId){
        try {
            if (childId != null){
                Integer id = new Integer(childId);
                return taskService.getTasksByChildId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return STATUS_ERROR;
    }

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public Object taskId(@PathVariable String taskId){
        try {
            if (taskId != null){
                Integer id = new Integer(taskId);
                return taskService.getById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return STATUS_ERROR;
    }

    @RequestMapping(value = "/task/add/{childId}", method = RequestMethod.POST)
    public Object addTask(@PathVariable String childId,
                       @RequestParam("name")String name,
                       @RequestParam("description")String description,
                       @RequestParam("ageRestriction")String ageRestriction,
                       @RequestParam("directionality")String directionality,
                       @RequestParam("urlImg")String urlImg,
                       @RequestParam("testImg")String testImg){
        try {
            if (childId != null){
                Integer id = new Integer(childId);
                Child child = childService.getById(id);
                Integer age = new Integer(ageRestriction);

                Task task = new Task(
                        name,
                        description,
                        age,
                        directionality,
                        urlImg,
                        testImg,
                        child
                );

                return taskService.save(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return STATUS_SUCCESS;
    }

    @RequestMapping(value = "/task/delete/{taskId}", method = RequestMethod.DELETE)
    public Object deleteTask(@PathVariable String taskId){
        try {
            if (taskId != null){
                Integer id = new Integer(taskId);
                taskService.delete(id);
                return STATUS_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_ERROR;
    }
}
