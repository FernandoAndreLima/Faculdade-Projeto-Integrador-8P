package iel.org.projeto_grid.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import iel.org.projeto_grid.model.entities.Disciplina;

/**
 * DAO for Disciplina
 */
public class DisciplinaDao extends BaseDao<Disciplina> {
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

	public Disciplina findById(Long id) {
		return em.find(Disciplina.class, id);
	}

	public List<Disciplina> listAll(Integer startPosition, Integer maxResult, Long idCurso) {
		TypedQuery<Disciplina> findAllQuery = em.createQuery("SELECT DISTINCT d FROM Disciplina d ORDER BY d.id",
				Disciplina.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		if(idCurso != null) {
			
		}
		return findAllQuery.getResultList();
	}

	public List<Disciplina> findAllDisciplinasOfTurma(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
