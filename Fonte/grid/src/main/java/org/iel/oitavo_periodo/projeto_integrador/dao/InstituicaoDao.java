package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.Instituicao;

/**
 * DAO for Instituicao
 */
@Stateless
public class InstituicaoDao extends BaseDao<Instituicao>{
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
	
	public Instituicao findById(Long id) {
		return em.find(Instituicao.class, id);
	}

	public List<Instituicao> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Instituicao> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT i FROM Instituicao i LEFT JOIN FETCH i.endereco ORDER BY i.id",
						Instituicao.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}


}
