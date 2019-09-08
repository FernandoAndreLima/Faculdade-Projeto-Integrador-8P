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
public class InstituicaoDao {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	public void create(Instituicao entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Instituicao entity = em.find(Instituicao.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Instituicao findById(Long id) {
		return em.find(Instituicao.class, id);
	}

	public Instituicao update(Instituicao entity) {
		return em.merge(entity);
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
