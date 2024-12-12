package io.github.im2back.challenge.CRUD.entities;

import java.time.LocalDate;

import io.github.im2back.challenge.CRUD.dto.ClientDtoInput;
import io.github.im2back.challenge.CRUD.dto.ClientDtoInputUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cpf;
	private Double income;
	private LocalDate birthDate;
	private Integer children;

	public Client(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public Client(ClientDtoInput client) {
		super();
		this.name = client.name();
		this.cpf = client.cpf();
		this.income = client.income();
		this.birthDate = client.birthDate();
		this.children = client.children();
	}

	public void update(ClientDtoInputUpdate dtoInput) {

		if (dtoInput.name() != null) {
			this.name = dtoInput.name();
		}
		if (dtoInput.cpf() != null) {
			this.cpf = dtoInput.cpf();
		}
		if (dtoInput.income() != null) {
			this.income = dtoInput.income();
		}
		if (dtoInput.birthDate() != null) {
			this.birthDate = dtoInput.birthDate();
		}
		if (dtoInput.children() != null) {
			this.children = dtoInput.children();
		}

	}

}
