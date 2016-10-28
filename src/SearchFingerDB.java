import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchFingerDB implements StrategyDB {

	@Override
	public String[] behaviourWithDB(String[] arrayInfoPerson) throws IOException, SQLException {

		String[] arrayInfoPersonReturn = new String[4];
		Connection dbConnection = null;
		Statement statement = null;

		final String insertInfoNewPerson = "SELECT typology, triradiusCore, numberCore, ridgeCount FROM L5 "
				+ "WHERE id = " + arrayInfoPerson[0];

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertInfoNewPerson);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(insertInfoNewPerson);

			while (rs.next()) {

				arrayInfoPersonReturn[0] = rs.getString("typology");
				arrayInfoPersonReturn[1] = rs.getString("triradiusCore");
				arrayInfoPersonReturn[2] = rs.getString("numberCore");
				arrayInfoPersonReturn[3] = rs.getString("ridgeCount");
				

			}

			System.out.println("typology : " + arrayInfoPersonReturn[0]);
			System.out.println("triradiusCore : " + arrayInfoPersonReturn[1]);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		return null;
	}

	private Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
