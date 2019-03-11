package text;

public class ReadText {
	public String get() {
		StringBuilder sb = new StringBuilder();
		//String s = "";//Ok
		char c = '#';
		try {
			while( (c = (char)System.in.read()) != 10 ) {
				sb.append(c);
			}
		}
		catch( java.io.IOException e) {
			//e.printStackTrace();
			//System.err.println("Exception:" + e);
		}
		return sb.toString();
	}
}
