package org.iel.oitavo_periodo.projeto_integrador.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.iel.oitavo_periodo.projeto_integrador.entities.DiaNaoDisponivel;

/**
 * 
 */
@Stateless
@Path("/dianaodisponivels")
public class DiaNaoDisponivelEndpoint {
	@PersistenceContext(unitName = "grid-persistence-unit")
	private EntityManager em;

	@POST
	@Consumes("application/xml")
	public Response create(DiaNaoDisponivel entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(DiaNaoDisponivelEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		DiaNaoDisponivel entity = em.find(DiaNaoDisponivel.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/xml")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<DiaNaoDisponivel> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT d FROM DiaNaoDisponivel d WHERE d.id = :entityId ORDER BY d.id",
						DiaNaoDisponivel.class);
		findByIdQuery.setParameter("entityId", id);
		DiaNaoDisponivel entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/xml")
	public List<DiaNaoDisponivel> listAll(
			@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<DiaNaoDisponivel> findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM DiaNaoDisponivel d ORDER BY d.id",
				DiaNaoDisponivel.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<DiaNaoDisponivel> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/xml")
	public Response update(@PathParam("id") Long id, DiaNaoDisponivel entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(DiaNaoDisponivel.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
