package com.medical.management.medlab_system.repository;

import com.medical.management.medlab_system.model.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestTypeRepository extends JpaRepository<TestType, Long> {

    Optional<TestType> findByName(String name);
}