package com.citizenservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservice.model.Citizen;
import com.citizenservice.service.CitizenService;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

	private final CitizenService citizenService;

	public CitizenController(CitizenService citizenService) {
		this.citizenService = citizenService;
	}

	@PostMapping("/create")
	public ResponseEntity<Citizen> createCitizen(@RequestBody Citizen citizen) {
		Citizen createCitizen = citizenService.createCitizen(citizen);
		return new ResponseEntity<>(createCitizen, HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Citizen> getCitizenById(@PathVariable("id") int id){
		Citizen citizenById = citizenService.getCitizenById(id);
		return new ResponseEntity<Citizen>(citizenById, HttpStatus.OK);
	}
	
	@GetMapping("/findByVaccinationCenterId/{findByVaccinationCenterId}")
	public ResponseEntity<List<Citizen>> findfindByVaccinationCenterId(@PathVariable("findByVaccinationCenterId") int id){
		List<Citizen> findByVaccinationCenterId = citizenService.findByVaccinationCenterId(id);
		return new ResponseEntity<>(findByVaccinationCenterId, HttpStatus.OK);
	}
}
