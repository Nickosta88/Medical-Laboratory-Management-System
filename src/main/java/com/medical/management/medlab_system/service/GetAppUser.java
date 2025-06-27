package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.exception.UserAlreadyExistsException;
import com.medical.management.medlab_system.mapper.UserMapper;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.model.Role;
import com.medical.management.medlab_system.repository.AppUserRepository;
import com.medical.management.medlab_system.repository.PatientRepository;
import com.medical.management.medlab_system.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAppUser {

    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AppUser getAppUserEntity(
            RegisterUserDto dto,
            AppUserRepository appUserRepository,
            String roleCode,
            BCryptPasswordEncoder encoder
    ) {
        if (appUserRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        Role role = roleRepository
                .findByRoleNameIgnoreCase(roleCode)
                .orElseThrow(() -> new IllegalStateException("Role" + roleCode + "not found"));

        String hashedPassword = encoder.encode(dto.getPassword());

        AppUser user = userMapper.toUser(dto, hashedPassword, role);

        return appUserRepository.save(user);
    }
}
