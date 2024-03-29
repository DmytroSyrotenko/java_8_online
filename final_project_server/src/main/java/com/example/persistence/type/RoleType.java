package com.example.persistence.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;


@Getter
@RequiredArgsConstructor
public enum RoleType {
    PERSONAL(Set.of(
            PermissionType.PERSONAL_CREATE,
            PermissionType.PERSONAL_READ,
            PermissionType.PERSONAL_UPDATE,
            PermissionType.PERSONAL_DELETE
    )),
    ADMIN(Set.of(
            PermissionType.ADMIN_CREATE,
            PermissionType.ADMIN_READ,
            PermissionType.ADMIN_UPDATE,
            PermissionType.ADMIN_DELETE
    ));


    private final Set<PermissionType> permissions;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority((permission.getPermission())))
                .toList();
    }
}
