package com.ordering_be.ordering_be_spring.Services;


import com.ordering_be.ordering_be_spring.Repository.MenuRepository;
import com.ordering_be.ordering_be_spring.entities.Menu;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;


    public Optional<Menu> getById(Long id) {
        return menuRepository.findById(id);
    }

    public List<Menu> getAll() {

        return menuRepository.findAll();
    }

    @Transactional
    public Menu add(String name, String description , float price) {
        Menu menu = menuRepository.saveAndFlush(new Menu(name,description, price));

        return menu;

    }
}