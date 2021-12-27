package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.Client;
import com.pixel.pixelproject.Entity.Order;
import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.Entity.PixelDto;
import com.pixel.pixelproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

   OrderRepository orderRepository;

   public OrderService(OrderRepository orderRepository) {
      this.orderRepository = orderRepository;
   }

   public void createOrder(List<PixelDto> hexs, Client client){
       List<Pixel> pixels=new ArrayList<>();
       for(PixelDto hex:hexs){
           pixels.add(new Pixel(hex));
       }
      LocalDateTime orderedDate = LocalDateTime.now();
      LocalDateTime deliveryDate=orderedDate.plusDays(30);
 Order order =new Order(client, pixels, deliveryDate, orderedDate, "");
 orderRepository.save(order);

   }



}
