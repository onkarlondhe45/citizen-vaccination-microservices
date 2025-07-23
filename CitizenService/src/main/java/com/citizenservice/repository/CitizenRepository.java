package com.citizenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizenservice.model.Citizen;
import java.util.List;


public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

	List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);
}
