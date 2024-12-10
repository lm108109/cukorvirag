package org.example.twenty_points.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.dto.OrderDto;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public ResponseEntity<Order> addOrder(@RequestParam String sweetName,
                                          @RequestParam int quantity,
                                          @RequestParam int price,
                                          @RequestParam String name,
                                          @RequestParam String telephoneNumber ,
                                          @RequestParam String email,
                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        Order order = orderService.createOrder(sweetName, quantity, price, name, telephoneNumber, email, date);
        return ResponseEntity.ok(order);

    }
    //get
    @Operation(summary = "get-orders")
    @GetMapping("/get-orders")
    public ResponseEntity<List<Order>> getOrder()
    {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    //update status

    @Operation(summary = "update status")
    @PutMapping("/update-status")
    public ResponseEntity<Order> updateOrder(@RequestParam Long orderId, @RequestParam OrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, orderStatus));
    }



}
