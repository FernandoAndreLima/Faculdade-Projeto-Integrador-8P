package org.iel.oitavo_periodo.projeto_integrador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		// TODO Auto-generated method stub
		return em;
	}

	public Turma findById(Long id) {
		return em.find(Turma.class, id);
	}
}
