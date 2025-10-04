package epsilongtmyon.app.endpoint.sandbox02.bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.enterprise.context.ApplicationScoped;

import epsilongtmyon.app.common.interceptor.annotation.Logging;

@ApplicationScoped
@Logging
public class Sandbox02Repository {

	private final DataSource dataSource;

	public Sandbox02Repository(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void register(String message) {

		String sql = """
				insert into HELLO (
				  MESSAGE
				) values (
				  ?
				)
				""";

		try (Connection con = dataSource.getConnection()) {
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, message);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
