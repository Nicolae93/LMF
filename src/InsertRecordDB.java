import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mkyong.file.CreateDirectory;

public class InsertRecordDB implements Strategy {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false";
	private static final String DB_USER = "root";
	private final static String DB_PASSWORD = "Cloudperme9353";
	private final String insertInfoNewPerson = "INSERT INTO person"
			+ "(firstname, lastname, birthdate, sex, nationality, email)  VALUES" + "(?,?,?,?,?,?)";
	
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;
	private CreateDirectory cd;
	private String scansDir = "/Users/dexter/Documents/LMF/scans";

	public void behaviourWithDB(String[] arrayInfoPerson, File[] filePathImgToMove) throws IOException, SQLException {

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertInfoNewPerson); // Operation
																				// to
																				// database,
																				// in
																				// this
																				// case
																				// is
																				// insert

			// prepare data to be insert
			prepareRecords(arrayInfoPerson);

			// execute insert SQL statement!
			preparedStatement.executeUpdate();
			System.out.println("Record is inserted into person table!");

			// Id is in ResultSet Object
			rs = getIdObjectTableNewPerson(arrayInfoPerson);

			// ID new person!
			int id = getIdNewPerson(rs);

			// salvare le immagini nella cartella, ho l'id e ho anche il path da
			// dove prendere le immagini

			// create a new directory in scans, named like the ID of the new
			// person
			cd = new CreateDirectory();
			cd.CreateSingleDirectory(id);

			// move the selectioned images
			// ho l'ID ho creato la cartella devo solo muovere i file nella
			// cartella... i file da muovere sono nel filePathImgToMove
			
			// move images selectioned by choose in to scaner/id folder :D 
			copyFile(id, filePathImgToMove);

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally { // Close the connection

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private void copyFile(int id, File[] filePathImgToMove) {
		InputStream inStream = null;
		OutputStream outStream = null;

		for (int i = 0; i < filePathImgToMove.length; i++) {

			try {

				File input = new File(filePathImgToMove[i].getPath());
				File output = new File(scansDir + "/" + id + "/"+ i + ".tif");

				inStream = new FileInputStream(input);
				outStream = new FileOutputStream(output);

				byte[] buffer = new byte[1024];

				int length;
				// copy the file content in bytes
				while ((length = inStream.read(buffer)) > 0) {

					outStream.write(buffer, 0, length);

				}

				inStream.close();
				outStream.close();

				// if you want not just to copy but to delete
				// afile.delete();

				System.out.println("File is copied successful!");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private int getIdNewPerson(ResultSet rs2) throws SQLException {
		int id = 0;
		while (rs2.next()) {
			id = rs2.getInt("id");
			System.out.println("ID: " + id);
		}
		return id;
	}

	private ResultSet getIdObjectTableNewPerson(String[] arrayInfoPerson) throws SQLException {

		return preparedStatement.executeQuery("SELECT id FROM person WHERE firstname='" + arrayInfoPerson[0]
				+ "'AND lastname='" + arrayInfoPerson[1] + "' AND birthdate='" + arrayInfoPerson[2] + "';");

	}

	private void prepareRecords(String[] arrayInfoPerson) throws SQLException {

		for (int i = 0; i < arrayInfoPerson.length - 1; i++) {
			preparedStatement.setString(i + 1, arrayInfoPerson[i]);
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

}
