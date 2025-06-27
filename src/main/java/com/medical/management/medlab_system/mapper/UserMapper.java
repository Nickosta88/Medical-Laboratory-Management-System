package com.medical.management.medlab_system.mapper;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.model.Role;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public AppUser toUser(RegisterUserDto dto, String encodedPassword, Role role) {
        return AppUser.builder()
                .email(dto.getEmail())
                .password(encodedPassword)
                .role(role)
                .telegramUsername(dto.getTelegramUsername())
                .build();
    }
}
