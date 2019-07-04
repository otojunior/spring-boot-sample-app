/**
 * 
 */
package org.otojunior.sample.app.backend.entity.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Getter
@Setter
@Entity
@Table(name = "revision")
@RevisionEntity(DefaultRevisionListener.class)
public class DefaultRevision {
	@Id
	@GeneratedValue
	@RevisionNumber
	@Column(name="rev")
	private Long revision;
	
	@RevisionTimestamp
	@Column(nullable=false)
	private Date modified;
	
	@Column(nullable=true, length=50)
	private String user;
}
