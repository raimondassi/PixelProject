package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.Entity.Client;
import com.pixel.pixelproject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

}
