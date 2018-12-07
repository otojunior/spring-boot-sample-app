/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import org.otojunior.sample.app.backend.entity.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{
}
