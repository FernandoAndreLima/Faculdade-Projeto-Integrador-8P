package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.DisponibilidadeProfessor;;

/**
 * DAO for DisponibilidadeProfessor
 */
@Stateless
public class DisponibilidadeProfessorDao {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	public void create(DisponibilidadeProfessor entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		DisponibilidadeProfessor entity = em.find(
				DisponibilidadeProfessor.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public DisponibilidadeProfessor findById(Long id) {
		return em.find(DisponibilidadeProfessor.class, id);
	}

	public DisponibilidadeProfessor update(DisponibilidadeProfessor entity) {
		return em.merge(entity);
	}

	public List<DisponibilidadeProfessor> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<DisponibilidadeProfessor> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT d FROM DisponibilidadeProfessor d LEFT JOIN FETCH d.professor ORDER BY d.id",
						DisponibilidadeProfessor.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
