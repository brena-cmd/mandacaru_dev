package mandacaru_ativ1.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import mandacaru_ativ1.dao.EstateDAO;
import mandacaru_ativ1.dao.EstateHibernateDAO;
import mandacaru_ativ1.entities.Estate;

@Path("/estates")
public class EstateController {
	EstateDAO estateDAO = new EstateHibernateDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estate> getAllProducts() {
		return estateDAO.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estate getById(@PathParam("id") int id) {
		return estateDAO.find(id);
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Estate getByName(@QueryParam("title") String title) {
		return estateDAO.findByName(title);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addProduct(@FormParam("title") String title, @FormParam("address") String address,
						   @FormParam("area") double area, @FormParam("areaBuilt") double areaBuilt,
						   @FormParam("rooms") int rooms, @FormParam("bathrooms") int bathrooms,
						   @FormParam("parking_spaces") int parking_spaces, @FormParam("price") double price) {
		Estate estate = new Estate(0, title, address, area, areaBuilt, rooms, bathrooms, parking_spaces, price);
		estateDAO.save(estate);
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateProduct(@PathParam("id") int id,@FormParam("title") String title, @FormParam("address") String address,
			   @FormParam("area") double area, @FormParam("areaBuilt") double areaBuilt,
			   @FormParam("rooms") int rooms, @FormParam("bathrooms") int bathrooms,
			   @FormParam("parking_spaces") int parking_spaces, @FormParam("price") double price) {
		Estate estate = new Estate(id, title, address, area, areaBuilt, rooms, bathrooms, parking_spaces, price);
		estateDAO.save(estate);
	}

	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam("id") int id) {
		estateDAO.delete(id);
	}
}
