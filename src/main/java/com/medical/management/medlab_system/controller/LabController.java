package com.medical.management.medlab_system.controller;

import com.medical.management.medlab_system.dto.RegisterUserDto;
import com.medical.management.medlab_system.dto.TestRequestDTO;
import com.medical.management.medlab_system.dto.UpdateTestRequestDTO;
import com.medical.management.medlab_system.model.TestType;
import com.medical.management.medlab_system.service.CreateLabService;
import com.medical.management.medlab_system.service.TestRequestService;
import com.medical.management.medlab_system.service.CreateAdminService;
import com.medical.management.medlab_system.service.TestTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lab")
@RequiredArgsConstructor
public class LabController {

    private final TestRequestService testRequestService;
    private final CreateLabService createLabService;
    private final TestTypeService testTypeService;

    @PostMapping("create/test-request")
    public ResponseEntity<Object> createTestRequest(@RequestBody @Valid TestRequestDTO dto) {

        return ResponseEntity.ok(Map.of(
                "message", "Test request created successfully",
                "request", testRequestService.createTestRequest(dto)
        ));
    }

    @PatchMapping("update/test-request/{id}")
    public ResponseEntity<Object> updateTestRequest(
            @RequestBody @Valid UpdateTestRequestDTO dto,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(Map.of(
                "message", "Test request updated successfully",
                "updatedRequest", testRequestService.updateTestRequest(dto, id)
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerLab(@RequestBody @Valid RegisterUserDto dto) {

        return ResponseEntity.ok(Map.of(
                "message", "Lab created successfully",
                "request", createLabService.registerLab(dto)
        ));
    }

    @GetMapping("/get/test-types")
    public ResponseEntity<Map<String, Object>> getTestTypes() {
        return ResponseEntity.ok(Map.of(
                "message", "List of test types",
                "request", testTypeService.getAllTestTypes()
        ));
    }

}
