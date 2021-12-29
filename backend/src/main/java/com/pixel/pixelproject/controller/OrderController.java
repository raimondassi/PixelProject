package com.pixel.pixelproject.controller;

import com.pixel.pixelproject.dto.OrderDto;
import com.pixel.pixelproject.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pixel.pixelproject.controller.ApiPath.ORDER;

@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(ORDER)
    public void createOrder(@RequestBody OrderDto orderDto){
       orderService.createOrder(orderDto);
    }


}
