package ru.devjava.averchenkov.springrest.scheduler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контроллер.
 *
 * @author Averchenkov R.A.
 */
@RestController
public class WebRestController {
    private final String STATUS_SUCCESS = "{status: success}";
    private final String STATUS_ERROR = "{status: error}";

    @RequestMapping(value = {"/", "/home", "/welcome"})
    public String home(){
        return STATUS_SUCCESS;
    }
}
