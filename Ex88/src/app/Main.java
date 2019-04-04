package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import java.util.List;


public class Main {
		
	public static void main(String[] args){
		String [] fs = new String[] { "./readme.txt"
									, "./readme1.txt"
									, "readme-copy.txt"
									};
		FileInputStreamEnumeration fenum = 
					new FileInputStreamEnumeration( Arrays.asList(fs));
		
		try( InputStream in = new SequenceInputStream(fenum)){
			int len = 0;
			byte [] buf = new byte[100];
			
			System.out.println("Before read, available:" + in.available());
			
			while( (len = in.read(buf)) != -1 ) {
				System.out.println("Bytes av:" + in.available());
				System.out.println( new String(buf));
			}
			
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}	
}

class FileInputStreamEnumeration implements Enumeration<FileInputStream>{
	private Enumeration<String> fileNames;
	
	public FileInputStreamEnumeration( List<String> fileNames) {
		this.fileNames = Collections.enumeration(fileNames);
	}
	@Override
	public boolean hasMoreElements() {
		return fileNames.hasMoreElements();
	}

	@Override
	public FileInputStream nextElement() {
		String fileName = fileNames.nextElement();
		try {
			return new FileInputStream(fileName);			
		}
		catch( FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
