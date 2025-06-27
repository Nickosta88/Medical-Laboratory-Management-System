package com.medical.management.medlab_system.repository;

import com.medical.management.medlab_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
