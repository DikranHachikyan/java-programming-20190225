package app;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
	public static final int CAPACITY = 120;
	
	public static void main(String[] args) {
		Path filePath = Paths.get("./readme.txt");
		try(SeekableByteChannel sbc = Files.newByteChannel( filePath, 
															StandardOpenOption.READ,
															StandardOpenOption.WRITE)){
			ByteBuffer buf = ByteBuffer.allocate(CAPACITY);
			int count = 0;
			while( (count = sbc.read(buf)) != -1 ) {
				buf.flip();
				System.out.println("====Read " + count + " bytes====");
				while( buf.hasRemaining()) {
					System.out.print((char)buf.get());
				}
				buf.clear();
			}
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}	
}