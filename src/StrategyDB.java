import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mkyong.file.CreateDirectory;

public interface StrategyDB {
	
	final String DB_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_CONNECTION = "jdbc:mysql://localhost:3306/LMF?autoReconnect=true&useSSL=false";
	final String DB_USER = "root";
	final String DB_PASSWORD = "Cloudperme9353";
	
	
	public String[] behaviourWithDB(String[] arrayInfoPerson) throws IOException, SQLException;

}
