package com.pixel.pixelproject.Controller;

import com.pixel.pixelproject.Entity.Order;
import com.pixel.pixelproject.Entity.dto.OrderDto;
import com.pixel.pixelproject.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void creteOrder(OrderDto orderDto){
       orderService.createOrder(orderDto);
    }


}
