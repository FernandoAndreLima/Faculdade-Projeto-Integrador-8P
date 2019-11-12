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
public class TurmaDao extends BaseDao<Turma> {
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

	public Turma findById(Long id) {
		TypedQuery<Turma> findAllQuery = em.createNamedQuery("Turma.busca", Turma.class);
		findAllQuery.setParameter("pId", id);
		return findAllQuery.getSingleResult();
	}
	
	public List<Turma> findAllWithCurso(Long idCurso) {
		
		em.getEntityManagerFactory().getCache().evictAll();
		
		TypedQuery<Turma> findAllQuery = em.createNamedQuery("Turma.listaPorCurso", Turma.class);
		findAllQuery.setParameter("pCursoId", idCurso);
		return findAllQuery.getResultList();
	}
}
