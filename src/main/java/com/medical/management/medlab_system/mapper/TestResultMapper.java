package com.medical.management.medlab_system.mapper;

import com.medical.management.medlab_system.dto.TestResultDto;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.model.TestRequest;
import com.medical.management.medlab_system.model.TestResult;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestResultMapper {

    public TestResult toEntity(TestResultDto dto, TestRequest testRequest, AppUser labTechnician, Boolean delay) {
        return TestResult.builder()
                .testRequest(testRequest)
                .resultData(dto.getResultData())
                .readyAt(LocalDate.now())
                .technicianId(Long.valueOf(dto.getLabTechnicianId()))
                .delay(delay)
                .labTechnician(labTechnician)
                .build();
    }
}
