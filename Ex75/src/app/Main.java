package app;

import java.io.File;

public class Main {
		
	public static void main(String[] args){
		File file = new File("./readme.txt");
		
		System.out.println("File name:" + file.getName());
		System.out.println("Path:" + file.getPath());
		System.out.println("Absolute Path:" + file.getAbsolutePath());
		System.out.println(file.getName() + ( file.exists() ? " exists": " does not exists"));
		System.out.println(file.getName() + ( file.canRead() ? " is readable": " is not readable"));
		System.out.println("Size:" + file.length() + " bytes");
		
	}	
}


