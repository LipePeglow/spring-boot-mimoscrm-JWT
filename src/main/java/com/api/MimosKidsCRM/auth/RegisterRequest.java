package com.api.MimosKidsCRM.auth;


import com.api.MimosKidsCRM.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private Role role;
}
