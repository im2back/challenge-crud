package io.github.im2back.challenge.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.im2back.challenge.CRUD.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
