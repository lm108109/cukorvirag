package org.example.twenty_points.controller;

import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class OrderControllerTest {
	
	private OrderService orderService;
	private OrderRepository orderRepository;
	private OrderController orderController;
	
	@BeforeEach
	void setUp() {
		orderService = mock(OrderService.class);
		orderRepository = mock(OrderRepository.class);
		orderController = new OrderController(orderService, orderRepository);
	}
	
	@Test
	void addOrderShouldReturnOrderWhenValidRequest() {
		Order order = new Order();
		when(orderService.createOrder(anyString(), anyInt(), anyInt(), anyString(), anyString(), anyString(), any(Date.class)))
				.thenReturn(order);
		
		ResponseEntity<Order> response = orderController.addOrder("sweetName", 1, 100, "name", "1234567890", "email@example.com", new Date());
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(order);
	}
	
	@Test
	void getOrderShouldReturnListOfOrders() {
		List<OrderDto> orders = Collections.singletonList(new OrderDto());
		when(orderService.getAllOrders()).thenReturn(orders);
		
		ResponseEntity<List<OrderDto>> response = orderController.getOrder();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(orders);
	}
	
	@Test
	void updateOrderShouldReturnUpdatedOrderWhenValidRequest() {
		Order order = new Order();
		when(orderService.updateOrder(anyLong(), any(OrderStatus.class))).thenReturn(order);
		
		ResponseEntity<Order> response = orderController.updateOrder(1L, OrderStatus.FINISHED);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(order);
	}
	
	@Test
	void updateOrderShouldReturnNotFoundWhenOrderDoesNotExist() {
		when(orderService.updateOrder(anyLong(), any(OrderStatus.class))).thenThrow(new RuntimeException("Order not found"));
		
		assertThrows(RuntimeException.class, () -> orderController.updateOrder(1L, OrderStatus.FINISHED));
	}
}