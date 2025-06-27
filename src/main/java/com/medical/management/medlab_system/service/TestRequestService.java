package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.TestRequestDTO;
import com.medical.management.medlab_system.dto.TestRequestResponseDTO;
import com.medical.management.medlab_system.dto.TestResultDto;
import com.medical.management.medlab_system.dto.UpdateTestRequestDTO;
import com.medical.management.medlab_system.exception.UserAlreadyExistsException;
import com.medical.management.medlab_system.mapper.TestRequestResponseMapper;
import com.medical.management.medlab_system.mapper.TestResultMapper;
import com.medical.management.medlab_system.model.TestRequest;
import com.medical.management.medlab_system.model.Patient;
import com.medical.management.medlab_system.model.TestType;
import com.medical.management.medlab_system.mapper.TestRequestMapper;
import com.medical.management.medlab_system.model.AppUser;
import com.medical.management.medlab_system.repository.*;
import com.medical.management.medlab_system.util.RoleCodes;
import com.medical.management.medlab_system.util.TestRequestStatuses;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestRequestService {

    private final TestRequestRepository testRequestRepository;
    private final TestResultMapper  testResultMapper;
    private final AppUserRepository appUserRepository;
    private final TestTypeRepository testTypeRepository;
    private final TestResultRepository  testResultRepository;
    private final TestRequestMapper testRequestMapper;

    @Transactional
    public TestRequest createTestRequest(TestRequestDTO dto) {
        Patient patient = this.getPatient(dto);
        TestType testType = this.getTestType(dto);

       TestRequest testRequest = testRequestMapper.toTestRequests(dto, patient, testType);
        return testRequestRepository.save(testRequest);
    }

    @Transactional
    public TestRequest updateTestRequest(UpdateTestRequestDTO dto, Long id) {
        Optional<TestRequest> testRequestOptional = testRequestRepository.findById(id);
        if (testRequestOptional.isPresent()) {
            TestRequest testRequest = testRequestOptional.get();
            testRequest.setStatus(dto.getStatus());

            //to do
            /*if(dto.getStatus().equals(TestRequestStatuses.COMPLETED)) {

            }*/

            return testRequestRepository.save(testRequest);
        } else {
            throw new IllegalStateException("Test request not found");
        }
    }

    public Patient getPatient(TestRequestDTO dto) {

        Optional<AppUser> userOptional = appUserRepository.findByEmail(dto.getPatientEmail());
        if (userOptional.isEmpty()) {
            throw new UserAlreadyExistsException("User doesn't exist");
        }

        AppUser user = userOptional.get();

        if (!RoleCodes.PATIENT.equals(user.getRole().getRoleName())) {
            throw new IllegalArgumentException("User is not a patient");
        }

        return user.getPatient();
    }

    public TestType getTestType(TestRequestDTO dto) {
        Optional<TestType> testTypeOptional = testTypeRepository.findByName(dto.getTestTypeName());
        if (testTypeOptional.isEmpty()) {
            throw new IllegalArgumentException("Test type not found");
        }
        return testTypeOptional.get();
    }

    public TestRequestResponseDTO getTestRequestDTO(Long id) {
        TestRequest request = testRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Test request not found"));

        return TestRequestResponseMapper.toDto(request);
    }
}
