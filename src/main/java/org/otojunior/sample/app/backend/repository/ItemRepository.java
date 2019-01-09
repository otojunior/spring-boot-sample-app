/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>ItemRepository interface.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	/**
	 * <p>findByCodigo.</p>
	 *
	 * @param codigo a {@link java.lang.Long} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByCodigo(Long codigo);
	/**
	 * <p>findByNome.</p>
	 *
	 * @param nome a {@link java.lang.String} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByNome(String nome);
}
