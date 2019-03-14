package text;

public class ReadText {
	public String get(){
		StringBuilder sb = new StringBuilder();
		//String s = "";//Ok
		char c = '#';
		try {			
			while( (c = (char)System.in.read()) != 10 ) {
				if( c == 'J' ) {
					throw new java.io.IOException("Invalid char:" + c);
				}
				sb.append(c);
			}
		}
		catch(java.io.IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("===finally===");
		}
		return sb.toString();
	}
}
