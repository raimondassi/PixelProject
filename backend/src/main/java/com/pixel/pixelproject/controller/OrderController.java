package com.pixel.pixelproject.controller;

import com.pixel.pixelproject.dto.OrderDto;
import com.pixel.pixelproject.entity.Order;
import com.pixel.pixelproject.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pixel.pixelproject.controller.ApiPath.ORDER;
import static com.pixel.pixelproject.controller.ApiPath.ROOT;

@RestController
@RequestMapping(ROOT + ORDER)
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }

    @ApiOperation(value = "Get all orders", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "received orders"),
            @ApiResponse(code = 403, message = "you do not have permisiions"),
            @ApiResponse(code = 401, message = "not connected")
    })
    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

}
