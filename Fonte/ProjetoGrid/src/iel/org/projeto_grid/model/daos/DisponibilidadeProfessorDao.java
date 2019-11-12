package iel.org.projeto_grid.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import iel.org.projeto_grid.model.entities.DisponibilidadeProfessor;;

/**
 * DAO for DisponibilidadeProfessor
 */
public class DisponibilidadeProfessorDao extends BaseDao<DisponibilidadeProfessor> {
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

	public DisponibilidadeProfessor findById(Long id) {
		return em.find(DisponibilidadeProfessor.class, id);
	}

	public List<DisponibilidadeProfessor> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<DisponibilidadeProfessor> findAllQuery = em.createQuery(
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
