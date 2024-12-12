package io.github.im2back.challenge.CRUD.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.im2back.challenge.CRUD.dto.ClientDtoInput;
import io.github.im2back.challenge.CRUD.dto.ClientDtoInputUpdate;
import io.github.im2back.challenge.CRUD.dto.ClientDtoOutput;
import io.github.im2back.challenge.CRUD.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;

	@GetMapping("/{id}")
	public ResponseEntity<ClientDtoOutput> getClientById(@PathVariable Long id) {
		ClientDtoOutput clientDtoOutput = clientService.getClientById(id);
		return ResponseEntity.ok(clientDtoOutput);
	}

	@GetMapping
	public ResponseEntity<Page<ClientDtoOutput>> findAllClients(Pageable pageable) {
		Page<ClientDtoOutput> clientDtoOutput = clientService.findAllClients(pageable);
		return ResponseEntity.ok(clientDtoOutput);
	}

	@PostMapping
	public ResponseEntity<ClientDtoOutput> saveNewClient(@RequestBody @Valid ClientDtoInput dtoInput,
			UriComponentsBuilder uriBuilder) {
		ClientDtoOutput clientDtoOutput = clientService.saveNewClient(dtoInput);

		var uri = uriBuilder.path("client/{id}").buildAndExpand(clientDtoOutput.id()).toUri();
		return ResponseEntity.created(uri).body(clientDtoOutput);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDtoOutput> updateClient(@RequestBody @Valid ClientDtoInputUpdate dtoInput,
			UriComponentsBuilder uriBuilder, @PathVariable Long id) {

		ClientDtoOutput clientDtoOutput = clientService.updateClient(dtoInput, id);

		return ResponseEntity.ok().body(clientDtoOutput);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		clientService.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
