/**
 * 
 */
package org.otojunior.sample.app.backend.entity.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class DefaultRevisionListener implements RevisionListener {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void newRevision(Object revisionEntity) {
		Authentication authentication = SecurityContextHolder
			.getContext()
			.getAuthentication();
		if ((authentication != null) &&
				!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    DefaultRevision revision = (DefaultRevision)revisionEntity;
		    revision.setUser(currentUserName);
		}
	}
}
