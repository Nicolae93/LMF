import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

	private Strategy strategy;

	public ConnectionDB(Strategy strategy) {

		this.strategy = strategy;

	}

	public void executeStrategy(String[] arrayInfoPerson) throws SQLException {

		strategy.behaviourWithDB(arrayInfoPerson);

	}

}