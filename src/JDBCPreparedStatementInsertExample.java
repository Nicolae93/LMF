import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatementInsertExample {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Cloudperme9353";

	public void insertRecordIntoTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String insertTableSQL = "INSERT INTO person"
				+ "(firstname, lastname, birthdate, sex, email, date_entered)  VALUES" + "(?,?,?,?,?,?)";
		

		try {
			
			dbConnection = getDBConnection();
			
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
//			preparedStatement.setString(1, "Giordano");
//			preparedStatement.setString(2, "Galeotti");
//			preparedStatement.setDate(3, java.sql.Date.valueOf("1993-04-17"));
//			preparedStatement.setString(4, "M");
//			preparedStatement.setString(5, "giordanino@yahoo.it");
//			preparedStatement.setTimestamp(6, getCurrentTimeStamp());
//			// execute insert SQL stetement
//			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into person table!");
			
			rs = preparedStatement.executeQuery("SELECT id FROM person where firstname='Lorenzo' and lastname='Buonavita'");
			int id=0;
			while (rs.next()) {
				id = rs.getInt("id");
				System.out.println("ID: " + id);
			}
			 
			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}


	private static Connection getDBConnection() {

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

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

}