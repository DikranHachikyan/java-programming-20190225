package app;

import java.io.File;

public class Main {
		
	public static void main(String[] args){
		String dirName = "./docs";
		File   dir  = new File(dirName);
		
		if ( dir.isDirectory()) {
			File [] names  = dir.listFiles();
			for( File name : names) {
				if( name.isDirectory()) {
					System.out.println("subdir:" + name.getName());
					continue;
				}
				System.out.println("file:" + name.getName());
					
			}
		}
		
	}	
}


