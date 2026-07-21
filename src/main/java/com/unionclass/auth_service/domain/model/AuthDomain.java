package com.unionclass.auth_service.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class AuthDomain {

    private String userId;
    private String loginId;
    private String password;
    private String email;
    private String name;
    private String phone;

    public static AuthDomain createSignUp(String loginId, String rawPassword, String email, String name, String phone) throws Exception {
        // userId > UUID or uniqkey
        // loginId 중복체크 and validate
        // email 중복체크 and validate
        // password 암호화 and validate
        // phone 중복체크 and validate
        validateLoginId(loginId);
        return AuthDomain.builder()
                .userId(UUID.randomUUID().toString())
                .loginId(loginId.trim())
                .email(email.trim())
                .password(rawPassword)
                .name(name.trim())
                .phone(phone.trim())
                .build();
    }

    private static void validateLoginId(String loginId) throws Exception {
        if(loginId == null || loginId.isBlank()) {
            throw new Exception("login Id 는 필수입니다.");
        }
        if(loginId.trim().length() < 4) {
            throw  new Exception("4자 이상이어야 합니다.");
        }
    }

    @Builder(access = AccessLevel.PRIVATE)
    public AuthDomain(String userId, String loginId, String password, String email, String name, String phone) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
