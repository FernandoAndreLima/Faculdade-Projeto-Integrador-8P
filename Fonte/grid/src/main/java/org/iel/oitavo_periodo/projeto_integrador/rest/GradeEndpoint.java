package org.iel.oitavo_periodo.projeto_integrador.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.iel.oitavo_periodo.projeto_integrador.entities.grade.GradeHoraria;
import org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum;
import org.iel.oitavo_periodo.projeto_integrador.util.UtilCreteFakeData;

@Consumes("application/json")
@Produces("application/json")
@Stateless
@Path("/grades")
public class GradeEndpoint {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	@Inject
	UtilCreteFakeData createDataFake;

	@POST
	@Path("/criar/")
	public Response createData() {
		createDataFake.createData();
		return Response.ok().build();
	}
	
	@GET
	public List<GradeHoraria> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<GradeHoraria> findAllQuery = em.createQuery("SELECT DISTINCT p FROM Professor p ORDER BY p.id",
				GradeHoraria.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<GradeHoraria> results = findAllQuery.getResultList();
		return results;
	}
	

}
