package iel.org.projeto_grid.model.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.iel.oitavo_periodo.projeto_integrador.entities.Usuario;

/**
 * DAO for Usuario
 */
@Stateless
public class UsuarioDao extends BaseDao<Usuario>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5991851604685124455L;
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Usuario> findAllQuery = em
				.createQuery("SELECT DISTINCT u FROM Usuario u ORDER BY u.id",
						Usuario.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
