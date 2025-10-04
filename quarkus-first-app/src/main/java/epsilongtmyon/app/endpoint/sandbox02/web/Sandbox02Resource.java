package epsilongtmyon.app.endpoint.sandbox02.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import epsilongtmyon.app.common.interceptor.annotation.Logging;
import epsilongtmyon.app.endpoint.sandbox02.bl.Sandbox02Service;
import epsilongtmyon.app.endpoint.sandbox02.web.spec.RegisterRequest;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

// commit / rollback の確認
// quarkus-agroalを追加するとデータソースとDB周りの機能が追加されている。

@Path("/sandbox02")
@ApplicationScoped
@Logging
public class Sandbox02Resource {

	private final Template sandbox02;

	private final Sandbox02Service sandbox02Service;

	public Sandbox02Resource(
			@Location("sandbox02/index.qute.html") Template sandbox02,
			Sandbox02Service sandbox02Service) {
		super();
		this.sandbox02 = sandbox02;
		this.sandbox02Service = sandbox02Service;
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get() {
		return sandbox02.instance();
	}

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(RegisterRequest request) {
		System.out.println(request);

		sandbox02Service.register(request.getMessage(), request.getCode());

		return Response.ok().build();
	}
}
