package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.Client;
import com.pixel.pixelproject.Entity.Order;
import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

   OrderRepository orderRepository;

   public OrderService(OrderRepository orderRepository) {
      this.orderRepository = orderRepository;
   }

   public void createOrder(List<Pixel> hexs, Client client){
      LocalDateTime orderedDate = LocalDateTime.now();
      LocalDateTime deliveryDate=orderedDate.plusDays(30);
 Order order =new Order(client, hexs, deliveryDate, orderedDate, "");
 orderRepository.save(order);

   }



}
