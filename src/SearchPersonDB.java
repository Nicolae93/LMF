import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mkyong.file.CreateDirectory;

public class SearchPersonDB implements StrategyDB {

	@Override
	public String[] behaviourWithDB(String[] arrayInfoPerson) throws IOException, SQLException {

		String[] arrayInfoPersonReturn = new String[7];
		Connection dbConnection = null;
		Statement statement = null;

		final String insertInfoNewPerson = "SELECT id, firstname, lastname, birthdate, sex, nationality, email FROM person "
				+ "WHERE id = " + arrayInfoPerson[0];

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertInfoNewPerson);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(insertInfoNewPerson);

			while (rs.next()) {
				arrayInfoPersonReturn[0] = rs.getString("id");
				arrayInfoPersonReturn[1] = rs.getString("firstname");
				arrayInfoPersonReturn[2] = rs.getString("lastname");
				arrayInfoPersonReturn[3] = rs.getString("birthdate");
				arrayInfoPersonReturn[4] = rs.getString("sex");
				arrayInfoPersonReturn[5] = rs.getString("nationality");
				arrayInfoPersonReturn[6] = rs.getString("email");

			}

			System.out.println("firstname : " + arrayInfoPersonReturn[0]);
			System.out.println("lastname : " + arrayInfoPersonReturn[1]);

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

		return arrayInfoPersonReturn;
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
