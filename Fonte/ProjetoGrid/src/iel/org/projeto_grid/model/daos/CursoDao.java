package iel.org.projeto_grid.model.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.Curso;

/**
 * DAO for Curso
 */
@Stateless
public class CursoDao extends BaseDao<Curso>{
	
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
	
	public Curso findById(Long id) {
		return em.find(Curso.class, id);
	}

	public List<Curso> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Curso> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Curso c ORDER BY c.id", Curso.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}


}
