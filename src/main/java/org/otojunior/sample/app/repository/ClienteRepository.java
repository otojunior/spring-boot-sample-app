/**
 * 
 */
package org.otojunior.sample.app.repository;

import org.otojunior.sample.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Cliente findByCpf(String cpf);
}
