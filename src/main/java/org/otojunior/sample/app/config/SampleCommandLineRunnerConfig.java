/**
 * 
 */
package org.otojunior.sample.app.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.Uf;
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
		
		Endereco endereco = new Endereco();
		endereco.setAtivo(true);
		endereco.setLogradouro("Rua Teste de Unidade");
		endereco.setNumero("123A");
		endereco.setBairro("Bairro Teste");
		endereco.setCidade("Belo Horizonte");
		endereco.setUf(Uf.MG);
		endereco.setCep("31234567");
		
		Cliente cliente = new Cliente();
		cliente.setCpf("00000000191");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setNome("Teste1");
		cliente.addEndereco(endereco);
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setCpf("00000000272");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setNome("Teste2");
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setCpf("00000000353");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setNome("Teste3");
		clientes.add(cliente);
		
		return clientes;
	}
}
