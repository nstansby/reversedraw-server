package com.wednesdaybeers.reversedraw.server.model.user;

import com.wednesdaybeers.reversedraw.server.model.oauth.Role;
import com.wednesdaybeers.reversedraw.server.model.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")

public class User extends BaseEntity {
    protected String name;
    protected String username;
    protected String password;
    protected boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "oauth_user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "oauth_role_id") })
    private Set<Role> roles = new HashSet<>();

    // Autogen setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
