package com.api.MimosKidsCRM.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN("admin"),
    USER("user");
    private final String permission;


}