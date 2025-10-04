package epsilongtmyon.app.endpoint.sandbox02.bl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import epsilongtmyon.app.common.interceptor.annotation.Logging;

@ApplicationScoped
@Transactional
@Logging
public class Sandbox02Service {

	private final Sandbox02Repository sandbox02Repository;

	public Sandbox02Service(Sandbox02Repository sandbox02Repository) {
		super();
		this.sandbox02Repository = sandbox02Repository;
	}

	public void register(String message, String code) {

		sandbox02Repository.register(message);

		if ("1".equals(code)) {
			// rollbackされている
			throw new RuntimeException("1");
		}
	}
}
