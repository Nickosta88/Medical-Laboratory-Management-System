package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.repository.RoleRepository;
import com.medical.management.medlab_system.repository.AppUserRepository;
import com.medical.management.medlab_system.util.RoleCodes;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class CreateLabService {

    private final AppUserRepository appUserRepository;
    private final GetAppUser getAppUser;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public AppUser registerLab(RegisterUserDto dto) {
        return getAppUser.getAppUserEntity(dto, appUserRepository, RoleCodes.LAB_TECHNICIAN, encoder);
    }

}
