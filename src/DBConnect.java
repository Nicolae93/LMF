import java.sql.*;

public class DBConnect {
	
	JDialogWindow dialog;
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "Cloudperme9353";
	
	
	//('Giordano','Galeotti',"1993-04-17",'M','giordanino@yahoo.it',now());
	
//	String insertTableSQL = "INSERT INTO person"
//			+ "(firstname, lastname, birthdate, sex, email, date_entered)  VALUES"
//			+ "(?,?,?,?,?,?)";
	
	
	public void getConnection() {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(DB_DRIVER);
		
		} catch (ClassNotFoundException e) {
			
			System.out.println("Class not found " + e);
		
		}

		try {
			
			con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			
			stmt = con.createStatement();
			
			// prendo l'array di info e le sbatto nel database, poi chiedo l'id per creare la cartella e sbatterci le immagini!
			
			dialog = new JDialogWindow();
			String[] arrayInfoPersone = dialog.getArrayInfoPerson();
			
			
			
			rs = stmt.executeQuery("SELECT * FROM person");
			rs = stmt.executeQuery("SELECT * FROM person");
			
			String firstname = null, lastname = null;
			while (rs.next()) {
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				System.out.println("firstname: " + firstname + "\n" + "lastname: " + lastname);
			}
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
					System.out.println("Connection ResultSet closed");
				} catch (SQLException e) {
					/* ignored */}
			}
			if (stmt != null) {
				try {
					stmt.close();
					System.out.println("Connection Sratement closed");
				} catch (SQLException e) {
					/* ignored */}
			}
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection Connection closed");
				} catch (SQLException e) {
					/* ignored */}
			}
		}
	}
}