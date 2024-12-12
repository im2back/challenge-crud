package io.github.im2back.challenge.CRUD.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.im2back.challenge.CRUD.dto.ClientDtoInput;
import io.github.im2back.challenge.CRUD.dto.ClientDtoInputUpdate;
import io.github.im2back.challenge.CRUD.dto.ClientDtoOutput;
import io.github.im2back.challenge.CRUD.entities.Client;
import io.github.im2back.challenge.CRUD.repository.ClientRepository;
import io.github.im2back.challenge.CRUD.service.exeptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientRepository clientRepository;

	@Transactional
	public ClientDtoOutput saveNewClient(ClientDtoInput dto) {

		Client client = new Client(dto);
		Client clientSaved = clientRepository.save(client);
		ClientDtoOutput clientDtoOutput = new ClientDtoOutput(clientSaved);

		return clientDtoOutput;

	}

	@Transactional(readOnly = true)
	public ClientDtoOutput getClientById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client not found for id:"+ id));
		ClientDtoOutput clientDtoOutput = new ClientDtoOutput(client);
		return clientDtoOutput;
	}

	@Transactional(readOnly = true)
	public Page<ClientDtoOutput> findAllClients(Pageable pageable) {

		Page<Client> clientPaged = clientRepository.findAll(pageable);
		Page<ClientDtoOutput> clientDtoOutputPaged = clientPaged.map(t -> new ClientDtoOutput(t));
		return clientDtoOutputPaged;
	}

	@Transactional
	public ClientDtoOutput updateClient(ClientDtoInputUpdate dtoInput) {
		
		Client client = getClient(dtoInput.id());
		client.update(dtoInput);
		
		Client clientSaved = clientRepository.save(client);
		
		ClientDtoOutput clientDtoOutput = new ClientDtoOutput(clientSaved);
		return clientDtoOutput;
	}
	
	@Transactional(readOnly = true)
	private Client getClient(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client not found for id:"+ id));	
	}

	public void deleteById(Long id) {
		Client client = getClient(id);
		clientRepository.deleteById(client.getId());
	}

}
