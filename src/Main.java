import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
			
//		Window window = new Window();		
//		window.createWindow();
		
		JDBCPreparedStatementInsertExample connection = new JDBCPreparedStatementInsertExample();
		
		try {

			connection.insertRecordIntoTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		
	}

}


