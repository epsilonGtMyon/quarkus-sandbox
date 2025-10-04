package epsilongtmyon.app.endpoint.sandbox03.web;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import epsilongtmyon.app.endpoint.sandbox03.web.spec.Get1Request;
import epsilongtmyon.app.endpoint.sandbox03.web.spec.Post1Request;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

// Validationの確認
// ValidatorをInjectして手動で検証もできるし
// Validアノテーションを引数につけることでメソッド実行前に検証してくれる。

@Path("/sandbox03")
@ApplicationScoped
public class Sandbox03Resource {

	private final Template sandbox03;

	public Sandbox03Resource(
			@Location("sandbox03/index.qute.html") Template sandbox03) {
		super();
		this.sandbox03 = sandbox03;
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get() {
		return sandbox03.instance();
	}

	@GET
	@Path("get1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get1(@Valid @BeanParam Get1Request request) {

		System.out.println(request);

		var body = Map.of("a", "b");
		return Response.ok(body).build();
	}

	@POST
	@Path("post1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post1(@Valid Post1Request request) {

		System.out.println(request);

		var body = Map.of("a", "b");
		return Response.ok(body).build();
	}
}
