package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.iel.oitavo_periodo.projeto_integrador.entities.Turma;

/**
 * DAO for Turma
 */
@Stateless
public class TurmaDao {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	public void create(Turma entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Turma entity = em.find(Turma.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Turma findById(Long id) {
		return em.find(Turma.class, id);
	}

	public Turma update(Turma entity) {
		return em.merge(entity);
	}

	public List<Turma> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Turma> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT t FROM Turma t LEFT JOIN FETCH t.curso ORDER BY t.id",
						Turma.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
