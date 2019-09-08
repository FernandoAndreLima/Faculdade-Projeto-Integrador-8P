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
public class TurmaDao extends BaseDao<Turma>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Turma findById(Long id) {
		return em.find(Turma.class, id);
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
