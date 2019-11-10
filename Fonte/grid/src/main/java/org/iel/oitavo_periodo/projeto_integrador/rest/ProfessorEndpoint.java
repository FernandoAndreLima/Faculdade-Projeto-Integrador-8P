package org.iel.oitavo_periodo.projeto_integrador.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * 
 */
@Stateless
@Path("/professores")
@Consumes("application/json")
@Produces("application/json")
public class ProfessorEndpoint {
//	@Inject
//	private ProfessorDao dao;

//	@GET
//	public List<Professor> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
//
//		return dao.listAll(startPosition, maxResult);
//	}
}
