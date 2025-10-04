package epsilongtmyon.app.endpoint.sandbox03.web.spec;

import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.QueryParam;

public class Get1Request {

	@NotEmpty
	@QueryParam("value01")
	private String value01;

	@NotEmpty
	@QueryParam("value02")
	private String value02;

	public String getValue01() {
		return value01;
	}

	public void setValue01(String value01) {
		this.value01 = value01;
	}

	public String getValue02() {
		return value02;
	}

	public void setValue02(String value02) {
		this.value02 = value02;
	}

	@Override
	public String toString() {
		return "Get1Request [value01=" + value01 + ", value02=" + value02 + "]";
	}

}
