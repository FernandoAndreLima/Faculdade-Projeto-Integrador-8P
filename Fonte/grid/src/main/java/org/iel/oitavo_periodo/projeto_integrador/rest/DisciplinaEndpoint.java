package org.iel.oitavo_periodo.projeto_integrador.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.iel.oitavo_periodo.projeto_integrador.dao.DisciplinaDao;
import org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina;

/**
 * 
 */
@Stateless
@Path("/disciplinas")
@Consumes("application/json")
@Produces("application/json")
public class DisciplinaEndpoint {
	@Inject
	private DisciplinaDao dao;

	@GET
	public List<Disciplina> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		return dao.listAll(startPosition, maxResult);
	}
}
