package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.iel.oitavo_periodo.projeto_integrador.entities.DiaNaoDisponivel;

/**
 * DAO for DiaNaoDisponivel
 */
@Stateless
public class DiaNaoDisponivelDao {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	public void create(DiaNaoDisponivel entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		DiaNaoDisponivel entity = em.find(DiaNaoDisponivel.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public DiaNaoDisponivel findById(Long id) {
		return em.find(DiaNaoDisponivel.class, id);
	}

	public DiaNaoDisponivel update(DiaNaoDisponivel entity) {
		return em.merge(entity);
	}

	public List<DiaNaoDisponivel> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<DiaNaoDisponivel> findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM DiaNaoDisponivel d ORDER BY d.id",
				DiaNaoDisponivel.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
