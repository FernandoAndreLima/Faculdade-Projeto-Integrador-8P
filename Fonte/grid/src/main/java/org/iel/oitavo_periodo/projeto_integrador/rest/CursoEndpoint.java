package org.iel.oitavo_periodo.projeto_integrador.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

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

	@POST
	public Response create(Curso entity) {
		cursoDao.save(entity);
		return Response
				.created(UriBuilder.fromResource(CursoEndpoint.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Curso entity = cursoDao.find(Curso.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		cursoDao.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/xml")
	public Response findById(@PathParam("id") Long id) {

		Curso entity;
		try {
			entity = cursoDao.findById(id);
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

//	@GET
//	@Produces("application/xml")
//	public List<Curso> listAll(@QueryParam("start") Integer startPosition,
//
//		List<C
//		return results;
//	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/xml")
	public Response update(@PathParam("id") Long id, Curso entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (cursoDao.find(Curso.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			cursoDao.update(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
