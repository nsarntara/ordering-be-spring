package com.ordering_be.ordering_be_spring.Repository;

import com.ordering_be.ordering_be_spring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}


