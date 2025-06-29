package com.ordering_be.ordering_be_spring.Controllers;

import com.ordering_be.ordering_be_spring.Services.MenuService;
import com.ordering_be.ordering_be_spring.entities.Menu;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Log4j2
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public List<Menu> getAll() {
        return menuService.getAll();

    }

    @GetMapping("/menu/{id}")
    public Menu getById(@PathVariable long id) {
        log.info("eve555{}", id);
        Menu menu = menuService.getById(id).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND, new Error("gg not found")));
        return menu;
    }

    @PostMapping("/menu")
    public Menu Add() {

        return menuService.add("eve", 100);
    }
}
