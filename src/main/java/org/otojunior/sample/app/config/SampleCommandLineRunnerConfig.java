/**
 * 
 */
package org.otojunior.sample.app.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author otojunior
 *
 */
@Configuration
public class SampleCommandLineRunnerConfig implements CommandLineRunner {
	@Autowired
	private ClienteRepository repository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(of());
	}
	
	/**
	 * 
	 * @return
	 */
	private List<Cliente> of() {
		List<Cliente> clientes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Cliente cliente = new Cliente();
			cliente.setCpf("00000000191");
			cliente.setDataNascimento(LocalDate.now());
			cliente.setNome("Teste " + i);
			clientes.add(cliente);
		}
		return clientes;
	}
}
