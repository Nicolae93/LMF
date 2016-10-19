import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public interface Strategy {

	public void behaviourWithDB(String[] arrayInfoPerson, File[] filePathImgToMove) throws IOException, SQLException;

}
