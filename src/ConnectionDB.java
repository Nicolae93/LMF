import java.sql.DriverManager;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

	private Strategy strategy;
	
	public ConnectionDB(Strategy strategy) {

		this.strategy = strategy;
	}

	public void executeStrategy(String[] arrayInfoPerson, File[] filePathImgToMove) throws SQLException, IOException {

		strategy.behaviourWithDB(arrayInfoPerson, filePathImgToMove);

	}

}