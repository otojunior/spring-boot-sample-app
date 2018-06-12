/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Optional<Cliente> findByCpf(String cpf);
}
