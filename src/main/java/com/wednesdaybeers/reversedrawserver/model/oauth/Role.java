package com.wednesdaybeers.reversedrawserver.model.oauth;

import com.wednesdaybeers.reversedrawserver.model.user.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "oauth_roles")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "oauth_user_roles", joinColumns = { @JoinColumn(name = "oauth_role_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}