package io.github.im2back.challenge.CRUD.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClientDtoInputUpdate(
		
		@NotNull(message = "Id obrigarorio em caso de update")
		Long id,
		
		@Size(max = 20,min = 6)
		String name,
		
		@CPF(message="cpf inválido")
		String cpf,
		
		Double income,

		LocalDate birthDate,

		Integer children

) {

}
