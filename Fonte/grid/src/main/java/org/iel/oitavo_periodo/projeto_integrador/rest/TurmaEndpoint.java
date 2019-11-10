package org.iel.oitavo_periodo.projeto_integrador.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.iel.oitavo_periodo.projeto_integrador.dao.TurmaDao;
import org.iel.oitavo_periodo.projeto_integrador.entities.Turma;
import org.iel.oitavo_periodo.projeto_integrador.entities.grade.GradeHoraria;

@Consumes("application/json")
@Produces("application/json")
@Stateless
@Path("/turmas")
public class TurmaEndpoint {

	@Inject
	TurmaDao turmaDao;

	@GET
	public List<Turma> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult, @QueryParam("id") Integer idCurso) {
		return turmaDao.findAllWithCurso((long)1);
	}
	
//	@GET
//	public Turma find() {
//		return turmaDao.findById((long) 56);
//	}

}
