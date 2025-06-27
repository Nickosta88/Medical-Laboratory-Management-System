package com.medical.management.medlab_system.controller;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.dto.TestTypeDTO;
import com.medical.management.medlab_system.service.CreateAdminService;
import com.medical.management.medlab_system.service.CreatePatientService;
import com.medical.management.medlab_system.service.TestRequestService;
import com.medical.management.medlab_system.validation.groups.OnRegisterPatient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final CreatePatientService createPatientService;
    private final TestRequestService testRequestService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerPatient(
            @RequestBody @Validated(OnRegisterPatient.class)
            RegisterUserDto dto
    ) {

        return ResponseEntity.ok(Map.of(
                "message", "Patient created successfully",
                "request", createPatientService.registerPatient(dto)
        ));
    }

    @GetMapping("/get/test-request/{id}")
    public ResponseEntity<Object> getTestRequest(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(Map.of(
                "message", "Test request number: " + id,
                "request", testRequestService.getTestRequestDTO(id)
        ));
    }
}
