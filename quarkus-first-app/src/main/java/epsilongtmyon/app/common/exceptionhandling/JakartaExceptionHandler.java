package epsilongtmyon.app.common.exceptionhandling;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

// Jakarta RESTの例外ハンドリング

// @Provider
public class JakartaExceptionHandler implements ExceptionMapper<Throwable> {
	
	@Override
	public Response toResponse(Throwable exception) {
		// リクエストとかはどこから受け取れる？？
		
		System.out.println(exception);
		Thread.dumpStack();
		return Response.status(500).build();
	}

}
