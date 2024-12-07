package org.example.twenty_points.service;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto order);

    List<OrderDto> getAllOrders();

    List<OrderDto> getOrdersByStatus(OrderStatus status);
}
