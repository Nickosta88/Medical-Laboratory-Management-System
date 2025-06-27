package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.model.Patient;
import com.medical.management.medlab_system.repository.AppUserRepository;
import com.medical.management.medlab_system.repository.PatientRepository;
import com.medical.management.medlab_system.util.RoleCodes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePatientService {

    private final AppUserRepository appUserRepository;
    private final GetAppUser getAppUser;
    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public Patient registerPatient(RegisterUserDto dto) {
        AppUser appUser = getAppUser.getAppUserEntity(dto, appUserRepository, RoleCodes.PATIENT, encoder);

        return patientRepository.save(createPatient(appUser, dto));
    }

    public Patient createPatient(AppUser appUser, RegisterUserDto dto) {

        return Patient.builder()
                .user(appUser)
                .phone(dto.getPhone())
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

}
