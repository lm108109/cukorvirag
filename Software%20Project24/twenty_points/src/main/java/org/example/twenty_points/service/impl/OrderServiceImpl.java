package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.repository.StorageRepository;
import org.example.twenty_points.service.OrderService;
import org.example.twenty_points.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StorageService storageService;
    private final StorageRepository storageRepository;

    public OrderServiceImpl(OrderRepository orderRepository, StorageService storageService, StorageRepository storageRepository) {
        this.orderRepository = orderRepository;
        this.storageService = storageService;
        this.storageRepository = storageRepository;
    }

    @Override
    public Order createOrder(String sweetName, int quantity,int price, String name, String telephoneNumber, String email, Date date) {
        Order newOrder = new Order();
        newOrder.setSweetName(sweetName);
        newOrder.setQuantity(quantity);
        newOrder.setPrice(price);
        newOrder.setStatus(OrderStatus.NEW);
        newOrder.setName(name);
        newOrder.setTelephoneNumber(telephoneNumber);
        newOrder.setEmail(email);
        newOrder.setDate(date);
        orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderDto::new)
                .toList();
    }


    @Override
    public List<OrderDto> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getStatus().equals(status))
                .map(OrderDto::new).toList();
    }


    @Override
    public Order updateOrder(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId);
        if (order.getStatus().equals(OrderStatus.NEW) && Boolean.TRUE.equals(storageService.checkStorage(order.getSweetName(), orderId))) {
            order.setStatus(status);
            return orderRepository.save(order);
        } else if (order.getStatus().equals(OrderStatus.IN_PROGRESS)) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        else {
            order.setStatus(OrderStatus.IN_PROGRESS.NEW);
            return orderRepository.save(order);
        }


    }

}
