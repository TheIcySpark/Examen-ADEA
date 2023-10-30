package com.adea.evaluation.service;

import com.adea.evaluation.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private UserModel user;

    public CustomUserDetails(UserModel user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
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
        if(user.getFechaVigencia() == null){
            return true;
        }
        return LocalDate.now().compareTo(user.getFechaVigencia()) <= 0;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
