package text;

public class ReadText {
	public String get() throws java.io.IOException {
		StringBuilder sb = new StringBuilder();
		//String s = "";//Ok
		char c = '#';

		while( (c = (char)System.in.read()) != 10 ) {
			if( c == 'J' ) {
				throw new java.io.IOException("Invalid char:" + c);
			}
			sb.append(c);
		}
		
		return sb.toString();
	}
}
