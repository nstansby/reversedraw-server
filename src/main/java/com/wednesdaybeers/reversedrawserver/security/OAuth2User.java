package com.wednesdaybeers.reversedrawserver.security;

import com.wednesdaybeers.reversedrawserver.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class OAuth2User extends User implements UserDetails {

    public OAuth2User(User user) {
        super();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

}
