package com.medical.management.medlab_system.service;

import com.medical.management.medlab_system.dto.TestTypeDTO;
import com.medical.management.medlab_system.mapper.TestTypeMapper;
import com.medical.management.medlab_system.model.TestType;
import com.medical.management.medlab_system.repository.TestTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TestTypeService {

    private final TestTypeRepository testTypeRepository;
    private final TestTypeMapper testTypeMapper;

    @Transactional
    public TestType createTestType(TestTypeDTO dto) {
        TestType testType = testTypeMapper.toTestTypes(dto);
        return testTypeRepository.save(testType);
    }

    @Transactional
    public TestType updateTestType(Long id,TestTypeDTO dto) {

        Optional<TestType> optionalTestTypes = testTypeRepository.findById(id);

        if(optionalTestTypes.isPresent()) {
            TestType testType = optionalTestTypes.get();
            testType.setName(dto.getName());
            testType.setDescription(dto.getDescription());
            testType.setPrice(dto.getPrice());
            return testTypeRepository.save(testType);
        } else {
            throw new IllegalStateException("Test type not found");
        }

    }

    public List<TestType> getAllTestTypes() {
        return testTypeRepository.findAll();
    }
}
