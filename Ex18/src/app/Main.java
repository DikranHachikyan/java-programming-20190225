package app;


public class Main {

	public static void main(String[] args) {
		int [][] values = {
				{11,22,33}, //row 0
				{44,55,66}, //row 1
				{77,88,99}  //,,,
		};
		
		for( int row = 0 ; row < values.length; row++) {
			for( int col = 0 ; col < values[row].length; col++) {
				System.out.print("["+ row + "][" + col + "]=>"+values[row][col] + "\t"); //\t ТАB
			}
			System.out.print("\n"); //нов ред
		}
	}

}
 