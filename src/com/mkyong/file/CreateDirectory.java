package com.mkyong.file;

import java.io.File;

public class CreateDirectory {

    public static void main(String[] args) {

        File file = new File("/Users/dexter/Documents/workspace/LMF_Project/Sub1");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File files = new File("/Users/dexter/Documents/workspace/LMF_Project/Sub2/Sub-Sub2");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }

    }

}