package com.medical.management.medlab_system.mapper;

import com.medical.management.medlab_system.dto.TestTypeDTO;
import com.medical.management.medlab_system.model.TestType;
import org.springframework.stereotype.Component;

@Component
public class TestTypeMapper {

    public TestType toTestTypes(TestTypeDTO dto) {
        return TestType.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
