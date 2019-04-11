package app;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
	public static final int CAPACITY = 1048576; //1MB
	
	public static void main(String[] args) {
		String fileName = "./mem.map";
		long start = System.currentTimeMillis();
		//System.out.println("start:" + start);
		try( FileChannel fchannel = FileChannel.open( Paths.get(fileName), 
													  StandardOpenOption.CREATE,
													  StandardOpenOption.READ,
													  StandardOpenOption.WRITE)){
			
			MappedByteBuffer mbb = fchannel.map(FileChannel.MapMode.READ_WRITE,
												0, //position
												CAPACITY); //size
			System.out.println("mem:pos=" + mbb.position() + 
					           " lim="    + mbb.limit()    + 
					           " cap="    + mbb.capacity());
			int n = CAPACITY >> 1; //побитово отместване с 1 бит => цел. дел. на 2
			System.out.println("n=" + n);
			for( int i = 0 ; i < n ; i++) {
				mbb.putChar( (char)('A' + i % 26));
			}
			System.out.println("mem:pos=" + mbb.position() + 
					" lim="    + mbb.limit()    + 
					" cap="    + mbb.capacity());
			
			mbb.flip();
			while( mbb.hasRemaining()) {
				char c = mbb.getChar();
				//System.out.print(c);
			}
			//System.out.println();
			
			long end = System.currentTimeMillis();
			System.out.printf("Exec Time: %f\n", (float)(end - start)/1000 );
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}	
}