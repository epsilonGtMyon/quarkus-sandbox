package epsilongtmyon.endpoint.sandbox01.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import epsilongtmyon.endpoint.sandbox01.bl.Sandbox01Service;
import epsilongtmyon.endpoint.sandbox01.web.spec.RegisterRequest;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@ApplicationScoped
@Path("/sandbox01")
public class Sandbox01Resource {
	
	private final Template sandbox01;

	private final Sandbox01Service sandbox01Service;

	public Sandbox01Resource(
			@Location("sandbox01/index.qute.html") Template sandbox01,
			Sandbox01Service sandbox01Service) {
		super();
		this.sandbox01 = sandbox01;
		this.sandbox01Service = sandbox01Service;
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get() {
		return sandbox01.instance();
	}

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(RegisterRequest request) {
		System.out.println(request);

		sandbox01Service.register(request.getMessage(), request.getCode());

		return Response.ok().build();
	}
}
