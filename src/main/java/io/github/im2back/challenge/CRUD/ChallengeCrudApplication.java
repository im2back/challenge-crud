package io.github.im2back.challenge.CRUD;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.im2back.challenge.CRUD.entities.Client;
import io.github.im2back.challenge.CRUD.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ChallengeCrudApplication implements CommandLineRunner {

	private final ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Client> clients = new ArrayList<>();

		clients.add(new Client("Ana Cardoso", "007.692.032-13", 20.00, LocalDate.of(2000, Month.JANUARY, 25), 2));
		clients.add(new Client("Bruno Silva", "123.456.789-00", 30.50, LocalDate.of(1995, Month.JUNE, 10), 1));
		clients.add(new Client("Carla Oliveira", "987.654.321-22", 15.25, LocalDate.of(1980, Month.MARCH, 15), 3));
		clients.add(new Client("Daniel Santos", "456.789.123-44", 50.00, LocalDate.of(2005, Month.SEPTEMBER, 5), 2));
		clients.add(new Client("Elisa Pereira", "789.123.456-66", 25.75, LocalDate.of(1970, Month.NOVEMBER, 20), 1));
		clients.add(new Client("Fábio Almeida", "111.222.333-88", 10.00, LocalDate.of(1992, Month.FEBRUARY, 28), 3));
		clients.add(new Client("Gabriela Costa", "333.444.555-00", 40.25, LocalDate.of(2010, Month.APRIL, 12), 2));
		clients.add(new Client("Henrique Souza", "555.666.777-22", 60.50, LocalDate.of(1965, Month.JULY, 5), 1));
		clients.add(new Client("Isabela Ramos", "777.888.999-44", 18.75, LocalDate.of(1998, Month.OCTOBER, 20), 3));
		clients.add(new Client("João Vieira", "999.000.111-66", 35.00, LocalDate.of(2002, Month.DECEMBER, 31), 2));

		clients.forEach(t -> clientRepository.save(t));

	}
}
