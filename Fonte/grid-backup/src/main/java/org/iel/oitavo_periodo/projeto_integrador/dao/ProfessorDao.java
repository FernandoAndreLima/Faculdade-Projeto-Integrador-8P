package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.Professor;

/**
 * DAO for Professor
 */
@Stateless
public class ProfessorDao extends BaseDao<Professor>{
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

	public Professor findById(Long id) {
		return em.find(Professor.class, id);
	}

	public List<Professor> findAllProfessoresOfTurma(Long idTurma){
		
		TypedQuery<Professor> findAllProfessores = em.createNamedQuery("Professor.listaTodosPorTurma", Professor.class);
		findAllProfessores.setParameter("pTurmaId", idTurma);
		
		return findAllProfessores.getResultList();
	}
	
//	public List<Professor> listAll(Integer startPosition, Integer maxResult) {
//		TypedQuery<Professor> findAllQuery = getEntityManager().createNamedQuery("Professor.listarTodos", Professor.class);
//		return findAllQuery.getResultList();
//	}
}
