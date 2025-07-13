package com.ordering_be.ordering_be_spring.Controllers;

import com.ordering_be.ordering_be_spring.Models.NewMenuRequest;
import com.ordering_be.ordering_be_spring.Services.MenuService;

import com.ordering_be.ordering_be_spring.entities.MenuItem;
import lombok.extern.log4j.Log4j2;
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
    public List<MenuItem> getAll() {
        return menuService.getAll();

    }

    @GetMapping("/menu/{id}")
    public MenuItem getById(@PathVariable long id) {
        log.info("get{}", id);
        MenuItem menu = menuService.getById(id).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND, new Error("gg not found")));
        return menu;
    }

    @PostMapping("/menu")
    public MenuItem Add ( @RequestBody NewMenuRequest newMenu ) {

        return menuService.add(newMenu.name ,newMenu.price );
    }
}
