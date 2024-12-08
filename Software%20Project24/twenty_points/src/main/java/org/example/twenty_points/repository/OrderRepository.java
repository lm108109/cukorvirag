package org.example.twenty_points.repository;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByName(String name);

    Order findAllByStatus(OrderStatus status);

    Order findById(Long id);

}
