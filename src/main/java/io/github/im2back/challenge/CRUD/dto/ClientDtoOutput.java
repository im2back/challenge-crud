package io.github.im2back.challenge.CRUD.dto;

import java.time.LocalDate;

import io.github.im2back.challenge.CRUD.entities.Client;

public record ClientDtoOutput(
		
		Long id,
		
		String name,

		String cpf,

		Double income,

		LocalDate birthDate,

		Integer children

) {

	public ClientDtoOutput(Client client) {
		this(client.getId(),client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildren());
	}

}
