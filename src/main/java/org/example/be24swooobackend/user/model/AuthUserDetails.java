package org.example.be24swooobackend.user.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class AuthUserDetails implements UserDetails {
    private Long idx;
    private String email;
    private String name;
    private String password;

    public AuthUserDetails(Long idx, String email, String name, String password) {
        this.idx = idx;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static AuthUserDetails from(User entity) {
        return AuthUserDetails.builder()
                .idx(entity.getIdx())
                .email(entity.getEmail())
                .name(entity.getName())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

}
