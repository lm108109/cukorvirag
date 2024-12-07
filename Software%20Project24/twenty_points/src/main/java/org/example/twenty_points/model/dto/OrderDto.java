package org.example.twenty_points.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twenty_points.model.Enum.OrderStatus;
import org.example.twenty_points.model.entity.Order;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Order data transfer objecct")
public class OrderDto {

    @Column(name = "sweetname")
    private String sweetname;

    @Column(name = "mennyiseg")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private Date date;

    public OrderDto(Order order) {
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
        this.status = order.getStatus();
        this.name = order.getName();
        this.email = order.getEmail();
        this.date = order.getDate();
    }
}


