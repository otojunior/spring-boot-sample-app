/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	public Optional<Item> findByCodigo(Long codigo);
	public Optional<Item> findByNome(String nome);
}
