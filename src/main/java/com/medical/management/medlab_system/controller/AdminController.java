package com.medical.management.medlab_system.controller;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.dto.TestTypeDTO;
import com.medical.management.medlab_system.service.TestTypeService;
import com.medical.management.medlab_system.service.CreateAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final CreateAdminService createAdminService;
    private final TestTypeService testTypeService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerAdmin(@RequestBody @Valid RegisterUserDto dto) {

        return ResponseEntity.ok(Map.of(
                "message", "Admin created successfully",
                "request", createAdminService.registerAdmin(dto)
        ));
    }

    @PostMapping("/create/test-type")
    public ResponseEntity<Object> createTestType(@RequestBody @Valid TestTypeDTO dto) {

        return ResponseEntity.ok(Map.of(
                "message", "Test type created successfully",
                "request", testTypeService.createTestType(dto)
        ));
    }

    @PutMapping("/update/test-type/{id}")
    public ResponseEntity<Object> updateTestType(
            @PathVariable Long id,
            @RequestBody @Valid TestTypeDTO dto
    ) {

        return ResponseEntity.ok(Map.of(
                "message", "Test type updated successfully",
                "request", testTypeService.updateTestType(id ,dto)
        ));
    }

}
