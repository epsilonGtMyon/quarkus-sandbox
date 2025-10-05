package epsilongtmyon.endpoint.sandbox01.bl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import epsilongtmyon.common.db.dao.HelloDao;
import epsilongtmyon.common.db.entity.Hello;

@ApplicationScoped
@Transactional
public class Sandbox01Service {

	private final HelloDao helloDao;

	public Sandbox01Service(HelloDao helloDao) {
		super();
		this.helloDao = helloDao;
	}

	public void register(String message, String code) {
		Hello hello = new Hello();
		hello.setMessage(message);

		helloDao.insert(hello);

		if ("1".equals(code)) {
			// rollbackされている
			throw new RuntimeException("1");
		}
	}
}
