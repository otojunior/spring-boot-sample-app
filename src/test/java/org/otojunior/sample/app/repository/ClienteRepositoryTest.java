/**
 * 
 */
package org.otojunior.sample.app.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.InformacaoContato;
import org.otojunior.sample.app.backend.entity.Uf;
import org.otojunior.sample.app.backend.repository.ClienteRepository;
import org.otojunior.sample.app.entity.ClienteTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ClienteRepository repository;
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ClienteRepository#findByCpf(java.lang.String)}.
	 */
	@Test
	public void testFindByCpf() {
		entityManager.persist(ClienteTest.of());
		
		Cliente cliente = repository.findByCpf("00000000191").orElse(null);
		assertNotNull(cliente);
		assertEquals("00000000191", cliente.getCpf());
		assertEquals("Joaquim da Silva", cliente.getNome());
		
		LocalDate dataNascimento = cliente.getDataNascimento();
		assertNotNull(dataNascimento);
		assertEquals(1975, dataNascimento.getYear());
		assertEquals(Month.JANUARY, dataNascimento.getMonth());
		assertEquals(15, dataNascimento.getDayOfMonth());
		
		InformacaoContato informacaoContato = cliente.getInformacaoContato();
		assertEquals("joaquim@teste.com", informacaoContato.getEmail());
		assertEquals("3122223333", informacaoContato.getTelefone());
		assertEquals("31988887777", informacaoContato.getCelular());

		Endereco endereco = cliente.getEnderecos().get(0);
		assertNotNull(endereco);
		assertEquals("Rua Teste de Unidade", endereco.getLogradouro());
		assertEquals("12345A", endereco.getNumero());
		assertEquals("AP 123 BL 99", endereco.getComplemento());
		assertEquals("Bairro Teste", endereco.getBairro());
		assertEquals("Belo Horizonte", endereco.getCidade());
		assertEquals(Uf.MG, endereco.getUf());
		assertEquals("30000000", endereco.getCep());
	}
}
