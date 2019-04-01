package app;

import java.io.File;
import java.io.FilenameFilter;

public class Main {
		
	public static void main(String[] args){
		String dirName = "./docs";
		File   drt  = new File(dirName);
		
		FilenameFilter filter = (dir,name)->name.endsWith(".java");
		
		File [] files = drt.listFiles(filter);
		for( File f : files) {
			System.out.println("File:" + f.getName());
		}
		
		File dirs = new File("./docs/a/b/c/d");
		dirs.mkdirs();
	}	
}


