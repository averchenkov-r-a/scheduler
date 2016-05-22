package ru.devjava.averchenkov.springrest.scheduler.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Child;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Parent;
import ru.devjava.averchenkov.springrest.scheduler.model.entity.Task;
import ru.devjava.averchenkov.springrest.scheduler.service.ChildService;
import ru.devjava.averchenkov.springrest.scheduler.service.ParentService;
import ru.devjava.averchenkov.springrest.scheduler.service.TaskService;

/**
 * Класс тестовой загрузки данных.
 *
 * @author Averchenkov R.A.
 */
@Component
public class BootLoader implements ApplicationListener<ContextRefreshedEvent> {
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Parent parent = new Parent(
                "parent",
                "123",
                "Марина",
                "Иванова"
        );
        Parent sParent = parentService.save(parent);

        Child child1 = new Child(
                "Петр",
                "Иванов",
                4.32,
                0.67,
                sParent
        );

        Child schild1 = childService.save(child1);

        Child child2 = new Child(
                "Виктор",
                "Иванов",
                8.32,
                0.76,
                sParent
        );

        Child schild2 = childService.save(child2);

        Task task1 = new Task(
                "Задача1",
                "Описание задачи модержащее много текста1.",
                4,
                "Наравленность1",
                "",
                "",
                schild1
        );

        Task task2 = new Task(
                "Задача2",
                "Описание задачи модержащее много текста2.",
                6,
                "Наравленность2",
                "",
                "",
                schild2
        );

        taskService.save(task1);
        taskService.save(task2);
    }
}
