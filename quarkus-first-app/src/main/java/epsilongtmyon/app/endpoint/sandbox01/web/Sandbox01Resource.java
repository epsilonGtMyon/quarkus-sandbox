package epsilongtmyon.app.endpoint.sandbox01.web;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import epsilongtmyon.app.endpoint.sandbox01.web.spec.Get1Request;
import epsilongtmyon.app.endpoint.sandbox01.web.spec.Post1Request;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

// 普通にリクエストを受け付ける

@Path("/sandbox01")
@ApplicationScoped
public class Sandbox01Resource {

	private final Template sandbox01;

	public Sandbox01Resource(
			// フィールドじゃなくてパラメータ側に@Locationは渡す。
			@Location("sandbox01/index.qute.html") Template sandbox01) {
		super();
		this.sandbox01 = sandbox01;
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get() {
		return sandbox01.instance();
	}

	@GET
	@Path("get1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get1(
			// まとめて一つのオブジェクトにしたいときは@BeanParam
			@BeanParam Get1Request request) {

		System.out.println(request);

		var body = Map.of("a", "b");
		return Response.ok(body).build();
	}

	@POST
	@Path("post1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post1(
			// アノテーションなしのものはボディがマッピング
			Post1Request request) {

		System.out.println(request);

		var body = Map.of("a", "b");
		return Response.ok(body).build();
	}
}
