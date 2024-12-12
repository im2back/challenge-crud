package io.github.im2back.challenge.CRUD.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public record ClientDtoInputUpdate(
			
		@Size(max = 20,min = 6)
		String name,
		
		String cpf,
		
		Double income,

		LocalDate birthDate,

		Integer children

) {

}
