package com.pixel.pixelproject;

import com.pixel.pixelproject.entity.Order;
import com.pixel.pixelproject.repository.OrderRepository;
import com.pixel.pixelproject.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void getAllOrdersTest() {
        Order order = new Order();
        List<Order> orders = List.of(order);
        when(orderRepository.findAll()).thenReturn(orders);
        List<Order> response = orderService.findAllOrders();
        Assertions.assertEquals(orders, response);
    }

    @Test
    public void getOrderByOrderIdTest() {
        Optional<Order> order = Optional.of(new Order());
        UUID id = UUID.fromString("9a6c2057-9c57-40b9-8aa3-9c6947ead1f3");
        when(orderRepository.findById(any())).thenReturn(order);
        Optional<Order> response = Optional.ofNullable(orderService.getOrder(id));
        Assertions.assertEquals(order, response);
    }

}