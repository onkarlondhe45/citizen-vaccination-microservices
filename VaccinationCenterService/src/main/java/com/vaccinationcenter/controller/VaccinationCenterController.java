package com.vaccinationcenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinationcenter.model.ResponseDto;
import com.vaccinationcenter.model.VaccinationCenter;
import com.vaccinationcenter.service.VaccinationCenterService;

@RestController
@RequestMapping("/api/vaccination/center")
public class VaccinationCenterController {

	private final VaccinationCenterService centerService;
	
	public VaccinationCenterController(VaccinationCenterService centerService) {
		this.centerService=centerService;
	}
	
	@PostMapping("create")
	public ResponseEntity<VaccinationCenter> create(@RequestBody VaccinationCenter vaccinationCenter){
		VaccinationCenter createVaccinationCenter = centerService.createVaccinationCenter(vaccinationCenter);
		return new ResponseEntity<>(createVaccinationCenter, HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseDto> getDetailsByVaccinationCenterId(@PathVariable("id") int id){
		ResponseDto detailsByVaccinationCenterId = centerService.getDetailsByVaccinationCenterId(id);
		return new ResponseEntity<>(detailsByVaccinationCenterId, HttpStatus.OK);
	}
}
