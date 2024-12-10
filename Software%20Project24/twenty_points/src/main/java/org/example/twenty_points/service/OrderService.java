package org.example.twenty_points.service;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    Order createOrder(String sweetName, int quantity, int price,  String name, String telephoneNumber, String email, Date date);

    List<Order> getAllOrders();

    List<OrderDto> getOrdersByStatus(OrderStatus status);

    Order updateOrder(Long orderId, OrderStatus status);
}
