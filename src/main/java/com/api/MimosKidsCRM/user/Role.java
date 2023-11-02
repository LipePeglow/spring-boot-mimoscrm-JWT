package com.api.MimosKidsCRM.user;


import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
public enum Role {
    USER("USER", new HashSet<Permission>()),
    ADMIN("ADMIN", new HashSet<Permission>());

    private final String authority;
    private final Set<Permission> permissions;

    Role(String authority, Set<Permission> permissions) {
        this.authority = authority;
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}


