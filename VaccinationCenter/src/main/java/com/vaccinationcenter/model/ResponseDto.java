package com.vaccinationcenter.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {

	private VaccinationCenter vaccinationCenter;
	private List<Citizen> citizens;
}
