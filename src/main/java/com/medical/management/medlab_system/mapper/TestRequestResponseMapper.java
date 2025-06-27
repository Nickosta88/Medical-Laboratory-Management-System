package com.medical.management.medlab_system.mapper;

import com.medical.management.medlab_system.dto.TestRequestResponseDTO;
import com.medical.management.medlab_system.model.TestRequest;

public class TestRequestResponseMapper {

    public static TestRequestResponseDTO toDto(TestRequest testRequest) {
        if (testRequest == null) return null;

        TestRequestResponseDTO dto = new TestRequestResponseDTO();
        dto.setId(testRequest.getId());

        if (testRequest.getPatient() != null && testRequest.getPatient().getUser() != null) {
            dto.setPatientEmail(testRequest.getPatient().getUser().getEmail());
        }

        if (testRequest.getTestType() != null) {
            dto.setTestTypeName(testRequest.getTestType().getName());
        }

        dto.setStatus(testRequest.getStatus());
        dto.setRequestedDate(testRequest.getRequestedAt());
        dto.setTentativeDate(testRequest.getTentativeDate());
        dto.setComment(testRequest.getComment());

        return dto;
    }
}
