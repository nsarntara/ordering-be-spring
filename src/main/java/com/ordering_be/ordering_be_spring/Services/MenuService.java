package com.ordering_be.ordering_be_spring.Services;


import com.ordering_be.ordering_be_spring.Repository.MenuRepository;
import com.ordering_be.ordering_be_spring.entities.MenuItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;


    public Optional<MenuItem> getById(Long id) {
        return menuRepository.findById(id);
    }

    public List<MenuItem> getAll() {

        return menuRepository.findAll();
    }

    @Transactional
    public MenuItem add(String name,BigDecimal price) {
        MenuItem menu = menuRepository.saveAndFlush(new MenuItem(name, price));

        return menu;

    }
}