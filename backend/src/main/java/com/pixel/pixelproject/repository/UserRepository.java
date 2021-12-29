package com.pixel.pixelproject.repository;

import com.pixel.pixelproject.dto.UserDto;
import com.pixel.pixelproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

}
