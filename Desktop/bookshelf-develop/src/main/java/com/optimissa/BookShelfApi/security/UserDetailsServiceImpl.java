package com.optimissa.BookShelfApi.security;

import com.optimissa.BookShelfApi.data.providers.IUserProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserProvider userProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponseDTO dto;
        if ((dto = userProvider.getUserByMail(username)) == null)
            throw new UsernameNotFoundException("username not found!");

        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singletonList(() -> dto.role);
            }

            @Override
            public String getPassword() {
                return dto.password;
            }

            @Override
            public String getUsername() {
                return dto.username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

    }

}
