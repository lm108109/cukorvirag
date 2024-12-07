package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order API")
@RestController
@CrossOrigin
@RequestMapping("/rest/auth")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderrepository) {
        this.orderRepository = orderrepository;
        this.orderService = orderService;
    }
    //add order
    @Operation(summary = "add new order")
    @PostMapping("/add-order")
    public ResponseEntity<OrderDto> addOrder(@RequestParam OrderDto orderDto)
    {
       return ResponseEntity.ok(orderService.createOrder(orderDto));
    }
    //get
    @Operation(summary = "get-orders")
    @GetMapping("/get-orders")
    public ResponseEntity<List<OrderDto>> getOrder()
    {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    //update status



}
