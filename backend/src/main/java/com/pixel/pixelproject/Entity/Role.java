package com.pixel.pixelproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
