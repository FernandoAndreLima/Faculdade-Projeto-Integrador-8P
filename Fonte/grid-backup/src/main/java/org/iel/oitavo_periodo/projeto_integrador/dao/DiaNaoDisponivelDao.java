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
public class DiaNaoDisponivelDao extends BaseDao<DiaNaoDisponivel>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public DiaNaoDisponivel findById(Long id) {
		return em.find(DiaNaoDisponivel.class, id);
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
