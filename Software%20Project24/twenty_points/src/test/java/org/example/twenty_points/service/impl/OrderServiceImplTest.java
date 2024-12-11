package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.service.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrderCreatesNewOrder() {
        Order order = new Order();
        order.setSweetName("Cake");
        order.setQuantity(2);
        order.setPrice(20);
        order.setStatus(OrderStatus.NEW);
        order.setName("John Doe");
        order.setTelephoneNumber("1234567890");
        order.setEmail("john.doe@example.com");
        order.setDate(new Date());

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.createOrder("Cake", 2, 20, "John Doe", "1234567890", "john.doe@example.com", new Date());

        assertEquals("Cake", result.getSweetName());
        assertEquals(2, result.getQuantity());
        assertEquals(20, result.getPrice());
        assertEquals(OrderStatus.NEW, result.getStatus());
        assertEquals("John Doe", result.getName());
        assertEquals("1234567890", result.getTelephoneNumber());
        assertEquals("john.doe@example.com", result.getEmail());
    }

    @Test
    void getAllOrdersReturnsListOfOrderDtos() {
        Order order = new Order();
        order.setSweetName("Cake");
        order.setQuantity(2);
        order.setPrice(20);
        order.setStatus(OrderStatus.NEW);
        order.setName("John Doe");
        order.setTelephoneNumber("1234567890");
        order.setEmail("john.doe@example.com");
        order.setDate(new Date());

        when(orderRepository.findAll()).thenReturn(List.of(order));

        List<OrderDto> result = orderService.getAllOrders();

        assertEquals(1, result.size());
        assertEquals("Cake", result.get(0).getSweetName());
        assertEquals(2, result.get(0).getQuantity());
        assertEquals(20, result.get(0).getPrice());
        assertEquals(OrderStatus.NEW, result.get(0).getStatus());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("1234567890", result.get(0).getTelephoneNumber());
        assertEquals("john.doe@example.com", result.get(0).getEmail());
    }

    @Test
    void getOrdersByStatusReturnsListOfOrderDtos() {
        Order order = new Order();
        order.setSweetName("Cake");
        order.setQuantity(2);
        order.setPrice(20);
        order.setStatus(OrderStatus.NEW);
        order.setName("John Doe");
        order.setTelephoneNumber("1234567890");
        order.setEmail("john.doe@example.com");
        order.setDate(new Date());

        when(orderRepository.findAll()).thenReturn(List.of(order));

        List<OrderDto> result = orderService.getOrdersByStatus(OrderStatus.NEW);

        assertEquals(1, result.size());
        assertEquals("Cake", result.get(0).getSweetName());
        assertEquals(2, result.get(0).getQuantity());
        assertEquals(20, result.get(0).getPrice());
        assertEquals(OrderStatus.NEW, result.get(0).getStatus());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("1234567890", result.get(0).getTelephoneNumber());
        assertEquals("john.doe@example.com", result.get(0).getEmail());
    }

    @Test
    void updateOrderUpdatesOrderStatus() {
        Order order = new Order();
        order.setId(1L);
        order.setSweetName("Cake");
        order.setQuantity(2);
        order.setPrice(20);
        order.setStatus(OrderStatus.NEW);
        order.setName("John Doe");
        order.setTelephoneNumber("1234567890");
        order.setEmail("john.doe@example.com");
        order.setDate(new Date());

        when(orderRepository.findById(1L)).thenReturn(order);
        when(storageService.checkStorage("Cake", 1L)).thenReturn(true);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.updateOrder(1L, OrderStatus.IN_PROGRESS);

        assertEquals(OrderStatus.IN_PROGRESS, result.getStatus());
    }

//    @Test
//    void updateOrderSetsStatusToInProgressWhenNewAndInsufficientStorage() {
//        Order order = new Order();
//        order.setId(1L);
//        order.setSweetName("Cake");
//        order.setQuantity(2);
//        order.setPrice(20);
//        order.setStatus(OrderStatus.NEW);
//        order.setName("John Doe");
//        order.setTelephoneNumber("1234567890");
//        order.setEmail("john.doe@example.com");
//        order.setDate(new Date());
//
//        when(orderRepository.findById(1L)).thenReturn(order);
//        when(storageService.checkStorage("Cake", 1L)).thenReturn(false);
//        when(orderRepository.save(any(Order.class))).thenReturn(order);
//
//        Order result = orderService.updateOrder(1L, OrderStatus.IN_PROGRESS);
//
//        assertEquals(OrderStatus.IN_PROGRESS, result.getStatus());
//    }
}