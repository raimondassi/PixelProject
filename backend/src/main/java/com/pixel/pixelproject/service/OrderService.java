package com.pixel.pixelproject.service;

import com.pixel.pixelproject.dto.ClientDto;
import com.pixel.pixelproject.dto.OrderDto;
import com.pixel.pixelproject.dto.PixelDto;
import com.pixel.pixelproject.entity.Client;
import com.pixel.pixelproject.entity.Order;
import com.pixel.pixelproject.entity.Pixel;
import com.pixel.pixelproject.entity.User;
import com.pixel.pixelproject.repository.ClientRepository;
import com.pixel.pixelproject.repository.OrderRepository;
import com.pixel.pixelproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    UserRepository userRepository;
    ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    public void createOrder(OrderDto orderDto) {
        ClientDto clientDto = orderDto.getClient();

        User user = userRepository.findByUsername(orderDto.getUsername()).get();
        List<Pixel> pixels = new ArrayList<>();
        for (PixelDto pixel : orderDto.getPixels()) {
            pixels.add(new Pixel(pixel));
        }

        Client clientGenerateId = new Client(clientDto, user);
        clientRepository.save(clientGenerateId);
        LocalDateTime orderedDate = LocalDateTime.now();
        LocalDateTime deliveryDate = orderedDate.plusDays(30);
        String picture = orderDto.getPicture();
        String description = orderDto.getDescription();
        Client client=clientRepository.findClientByEmail(clientDto.getEmail()).get();

        Order order = new Order(client, pixels, deliveryDate, orderedDate, description, picture);
        orderRepository.save(order);

    }

}
