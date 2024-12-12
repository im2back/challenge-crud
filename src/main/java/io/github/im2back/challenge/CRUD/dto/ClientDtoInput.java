package io.github.im2back.challenge.CRUD.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record ClientDtoInput(
		
		 @NotBlank(message = "O nome é obrigatório")
		 @Size(max = 20,min = 6)
		 String name,
		 
		 @NotBlank(message = "Forneça um CPF válido.")
		 String cpf,
		 
		 @NotNull(message = "Informe uma renda válida")
		 Double income,
		 
		 @PastOrPresent
		 LocalDate birthDate,
		 
		 @NotNull(message = "Informe uma quantidade válida")
		 Integer children
		
		) {

}
