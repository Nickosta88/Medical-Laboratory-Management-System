package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.repository.RoleRepository;
import com.medical.management.medlab_system.repository.AppUserRepository;
import com.medical.management.medlab_system.util.RoleCodes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAdminService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final  GetAppUser getAppUser;

    @Transactional
    public AppUser registerAdmin(RegisterUserDto dto) {

        return getAppUser.getAppUserEntity(dto, appUserRepository, RoleCodes.ADMIN, encoder);
    }
}
