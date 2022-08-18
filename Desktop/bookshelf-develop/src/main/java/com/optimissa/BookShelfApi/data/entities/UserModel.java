package com.optimissa.BookShelfApi.data.entities;

import com.optimissa.BookShelfApi.data.entities.enums.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"mail", "username"})
@ToString(exclude = "password")
@Builder
@Table(name = "USERS")
public class UserModel implements UserDetails {

    @Id
    @Column(unique = true) private String mail;
    @Column(unique = true) private String username;
    @Column(nullable = false) private String password;
    @Enumerated(EnumType.STRING) private UserRole role;
    private boolean locked = false;
    private boolean enabled = true;
    private LocalDateTime createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> role.name());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
