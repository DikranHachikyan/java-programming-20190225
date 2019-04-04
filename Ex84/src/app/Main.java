package app;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		String s = "Lorem #ipsum# dolor sit amet, #consectetur# adipisicing #elit#";
		int length = s.length();
		char [] chrs = new char[length];
		boolean marked = false;
		
		s.getChars(0, length, chrs, 0);
		int c = 0;
		int pos = 0;
		int i = 0;
		
		try( CharArrayReader car = new CharArrayReader(chrs);
			 CharArrayWriter caw = new CharArrayWriter()){
			 while( (c = car.read()) != -1) {
				if( (char)c == '#' ) {
					if( !marked ) { //няма маркер в потока
						car.mark(0);
						pos = i;
					}
					else {         //потока вече маркиран, прочитаме м/у маркерите
						car.reset(); //връщаме се към 1-я маркер
						while( pos < (i -1 ) && (c = car.read()) != -1) {
							caw.write(c);
							pos++;
						}
						caw.write('|');
						car.skip(2);
					} // if not marked
					marked = !marked;
				} //if c == #
				i++;
			 }//while
			 
			 System.out.println("Result:" + caw);
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}	
}


