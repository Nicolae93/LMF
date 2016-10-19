package com.mkyong.file;

import java.io.File;

public class CreateDirectory {
	
	//Method 1
	public void CreateSingleDirectory(int id) {

		File file = new File("/Users/dexter/Documents/LMF/scans/" + Integer.toString(id));
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

	}
	
	//Method 2
	public void CreateMultipleDirectorys() {
		File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}
	}

}