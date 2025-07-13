package com.ordering_be.ordering_be_spring.Repository;

import com.ordering_be.ordering_be_spring.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    public  Menu findFirstBy();
    public  Menu findFirstByName();
}

