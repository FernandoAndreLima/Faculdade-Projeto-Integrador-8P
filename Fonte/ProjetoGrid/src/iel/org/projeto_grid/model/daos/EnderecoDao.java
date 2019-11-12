package iel.org.projeto_grid.model.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.Endereco;

/**
 * DAO for Endereco
 */
@Stateless
public class EnderecoDao extends BaseDao<Endereco> {
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

	public Endereco findById(Long id) {
		return em.find(Endereco.class, id);
	}

	public List<Endereco> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Endereco> findAllQuery = em.createQuery("SELECT DISTINCT e FROM Endereco e ORDER BY e.id",
				Endereco.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

}
