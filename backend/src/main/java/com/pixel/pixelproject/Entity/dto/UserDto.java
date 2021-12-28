package com.pixel.pixelproject.Entity.dto;

import com.pixel.pixelproject.Entity.Role;
import com.pixel.pixelproject.Entity.User;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String loginName;
    private Set<String> roles;

    public UserDto(User user) {
        loginName = user.getUsername();
        roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
    }
}
