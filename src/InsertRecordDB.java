import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertRecordDB implements Strategy {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Cloudperme9353";

	public void behaviourWithDB(String[] arrayInfoPerson) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String insertTableSQL = "INSERT INTO person"
				+ "(firstname, lastname, birthdate, sex, email, date_entered)  VALUES" + "(?,?,?,?,?,?)";
		System.out.println(4);
		try {

			dbConnection = getDBConnection();
			
			System.out.println(5);
			
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			System.out.println(6);
			preparedStatement.setString(1, arrayInfoPerson[0]);
			preparedStatement.setString(2, arrayInfoPerson[1]);
			System.out.println(7);
			System.out.println(java.sql.Date.valueOf(arrayInfoPerson[2]));
			preparedStatement.setDate(3, java.sql.Date.valueOf(arrayInfoPerson[2]));
			System.out.println(8);
			preparedStatement.setString(4, arrayInfoPerson[3]);
			preparedStatement.setString(5, arrayInfoPerson[4]);
			preparedStatement.setTimestamp(6, getCurrentTimeStamp());
			
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into person table!");

			rs = preparedStatement
					.executeQuery("SELECT id FROM person where firstname='Lorenzo' and lastname='Buonavita'");
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
				System.out.println("ID: " + id);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally { // Close the connection

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
