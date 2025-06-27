package com.medical.management.medlab_system.mapper;

import com.medical.management.medlab_system.dto.TestRequestDTO;
import com.medical.management.medlab_system.model.Patient;
import com.medical.management.medlab_system.model.TestRequest;
import com.medical.management.medlab_system.model.TestType;
import com.medical.management.medlab_system.util.TestRequestStatuses;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestRequestMapper {

    public TestRequest toTestRequests(
            TestRequestDTO dto,
            Patient patient,
            TestType testType
    ) {
        return TestRequest.builder()
                .patient(patient)
                .testType(testType)
                .status(TestRequestStatuses.IN_PROGRESS)
                .tentativeDate(dto.getTentativeDate())
                .comment(dto.getComment())
                .build();

    }

}
