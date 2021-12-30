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
import com.pixel.pixelproject.repository.PixelRepository;
import com.pixel.pixelproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    OrderRepository orderRepository;
    UserRepository userRepository;
    ClientRepository clientRepository;
    PixelRepository pixelRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ClientRepository clientRepository, PixelRepository pixelRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.pixelRepository = pixelRepository;
    }

    public void createOrder(OrderDto orderDto) {
        ClientDto clientDto = orderDto.getClient();

        User user = userRepository.findByUsername(orderDto.getUsername()).get();
        List<Pixel> pixels = new ArrayList<>();
        for (PixelDto pixel : orderDto.getPixels()) {
            pixels.add(new Pixel(pixel));
        }
        List<Pixel> pixelsInRepo = new ArrayList<>();
        for (Pixel pixel : pixels) {
            pixelRepository.save(pixel);
            pixelsInRepo.add(pixel);
        }

        Client clientGenerateId = new Client(clientDto, user);
        clientRepository.save(clientGenerateId);
        LocalDateTime orderedDate = LocalDateTime.now();
        LocalDateTime deliveryDate = orderedDate.plusDays(30);
        String picture = orderDto.getPicture();
        String description = orderDto.getDescription();
        Client client = clientRepository.findClientByEmail(clientDto.getEmail()).get();
        List<Pixel> pixelsFromRepo = new ArrayList<>();
        for (Pixel pixel : pixelsInRepo) {
            pixelRepository.findByColorAndAndSizeAndAndProcentage(pixel.getColor(), pixel.getSize(), pixel.getProcentage());
            pixelsFromRepo.add(pixel);
        }

        Order order = new Order(client, pixelsFromRepo, deliveryDate, orderedDate, description);
        orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).get();
    }

}
