package br.com.renan.ExemploSpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.renan.domain.Cliente;
import br.com.renan.repository.IClienteRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.renan.repository")
@EntityScan(basePackages = "br.com.renan.domain")  
public class ExemploSpringBootApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ExemploSpringBootApplication.class);
	
	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		
		repository.deleteAll();
		
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("SP")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.end("End")
				.estado("SP")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}
}