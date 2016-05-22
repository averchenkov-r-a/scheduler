package ru.devjava.averchenkov.springrest.scheduler.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Класс тестовой загрузки данных.
 *
 * @author Averchenkov R.A.
 */
public class BootLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
