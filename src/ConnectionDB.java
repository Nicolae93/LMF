
import java.sql.DriverManager;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

	private StrategyDB strategy;
	
	public ConnectionDB(StrategyDB strategy) {

		this.strategy = strategy;
	}

	public String[] executeStrategy(String[] arrayInfoPerson) throws SQLException, IOException {

		return strategy.behaviourWithDB(arrayInfoPerson);

	}

}