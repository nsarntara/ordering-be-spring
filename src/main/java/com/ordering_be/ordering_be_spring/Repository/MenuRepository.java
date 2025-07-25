package com.ordering_be.ordering_be_spring.Repository;

import com.ordering_be.ordering_be_spring.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}

