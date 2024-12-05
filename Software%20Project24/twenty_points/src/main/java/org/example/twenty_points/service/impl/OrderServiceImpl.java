package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto order) {

        Order newOrder = new Order();
        newOrder.setQuantity(order.getQuantity());
        newOrder.setPrice(order.getPrice());
        newOrder.setStatus(OrderStatus.NEW);
        newOrder.setName(order.getName());
        newOrder.setTelefonNumber(order.getTelefonNumber());
        newOrder.setEmail(order.getEmail());
        newOrder.setDate(order.getDate());
        orderRepository.save(newOrder);
        return new OrderDto(newOrder);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orders = new ArrayList<>();
        orderRepository.findAll().forEach(order -> {
            OrderDto orderDto = new OrderDto(order);
            orders.add(orderDto);
        });
        return orders;
    }

    @Override
    public List<OrderDto> getOrdersByStatus(OrderStatus status) {
        List<OrderDto> orders = new ArrayList<>();
        orderRepository.findAll().forEach(order -> {
            if (order.getStatus().equals(status)) {
                OrderDto orderDto = new OrderDto(order);
                orders.add(orderDto);
            }
        });
        return orders;
    }
}
