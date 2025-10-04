package epsilongtmyon.app.common.exceptionhandling;

import org.jboss.resteasy.reactive.RestResponse;

import io.vertx.core.http.HttpServerRequest;

// Quarkusの例外ハンドリング

public class QuarkusExceptionHandler {

	//@ServerExceptionMapper
	public RestResponse<?> handle(
			Exception ex,
			HttpServerRequest request) throws Exception{
		
		// メソッドの引数でいろいろ受け取れそう
		
		Thread.dumpStack();

		//throw ex;
		return RestResponse.status(500);
	}
}
