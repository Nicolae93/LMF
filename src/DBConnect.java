import java.sql.*;

public class DBConnect {
	
	public DBConnect(){
		geConnection();
	}
	
	public void geConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		System.out.println("JDBC Class found");
		int no_of_rows = 0;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false", "root", "Cloudperme9353");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM persona");
			String name = null, lastname = null;
			while (rs.next()) {
				name = rs.getString("first_name");
				lastname = rs.getString("last_name");
			}
			System.out.println("first name: " + name + "\n"
			+ "last name: " + lastname);
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}