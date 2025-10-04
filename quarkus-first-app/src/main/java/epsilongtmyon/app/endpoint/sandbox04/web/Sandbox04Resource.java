package epsilongtmyon.app.endpoint.sandbox04.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/sandbox04")
@ApplicationScoped
public class Sandbox04Resource {

	@GET
	@Path("get1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get1() {
		throw new RuntimeException("get1");
	}
}
