package org.iel.oitavo_periodo.projeto_integrador.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.iel.oitavo_periodo.projeto_integrador.dao.CursoDao;
import org.iel.oitavo_periodo.projeto_integrador.entities.Curso;

/**
 * 
 */
@Stateless
@Path("/cursos")
@Consumes("application/json")
@Produces("application/json")
public class CursoEndpoint {

	@Inject
	private CursoDao cursoDao;

	@GET
	public List<Curso> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult){
		
		return cursoDao.listAll(startPosition, maxResult);
	}
}
