package com.pixel.pixelproject.service;

import com.pixel.pixelproject.Entity.Client;
import com.pixel.pixelproject.Entity.Order;
import com.pixel.pixelproject.Entity.Pixel;
import com.pixel.pixelproject.Entity.dto.OrderDto;
import com.pixel.pixelproject.Entity.dto.PixelDto;
import com.pixel.pixelproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

   OrderRepository orderRepository;

   public OrderService(OrderRepository orderRepository) {
      this.orderRepository = orderRepository;
   }

   public void createOrder(OrderDto orderDto){
       List<Pixel> pixels=new ArrayList<>();
       for(PixelDto pixel:orderDto.getPixels()){
           pixels.add(new Pixel(pixel));
       }
       Client client=new Client();
      LocalDateTime orderedDate = LocalDateTime.now();
      LocalDateTime deliveryDate=orderedDate.plusDays(30);

 Order order =new Order(client, pixels, deliveryDate, orderedDate, "");
 orderRepository.save(order);

   }



}
