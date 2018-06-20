/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	public Optional<Endereco> findByCep(String cep);
}
