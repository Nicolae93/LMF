package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFilesTest {

	public static void main(String[] args) {

		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File("/Users/dexter/Desktop/DatiTirocinio/Tif_Img/IMG_0001.tif");
			File bfile = new File("/Users/dexter/Documents/LMF/scans/img.tif");

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

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
