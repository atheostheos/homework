import java.util.Collections;
import java.util.Arrays;

public class ShowPascalTriangle {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.parseInt(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
			System.exit(1);
		}

		int n = Integer.parseInt(args[0]);
		int[][] seq = new int[n][n]; //seq[i][0] - previous line, seq[i][1] - new line

		seq[0][0] = 1;

		for (int i = 1; i < n; i++) {
			for (int j=0; j <= i; j++) {
				if ( (j == 0 ) || (j == i) ) {
					seq[i][j] = 1;
				} else {
					seq[i][j] = seq[i-1][j-1] + seq[i-1][j];
				}
			}
		}

		int maxNumLen = String.valueOf(seq[n-1][n/2]).length(); //length of the biggest number
		int maxLineLen = maxNumLen*(n) + n-1; //length of the longest line


		for (int i = 0; i < n; i++) {

			int lineLen = maxNumLen*(i+1) + i; //length of the current line
			int padding = (maxLineLen - lineLen)/2; //amount of spaces needed to center the line
			for ( int s = 0; s < padding; s++) {
				System.out.print(" ");
			}

			for (int j=0; j <= i; j++) {
				int numLen = String.valueOf(seq[i][j]).length();
				int numTabs = (maxNumLen - numLen)/2; //number of tabs needed to center the number on one side: __num__

				String tabs = String.join("", Collections.nCopies((numTabs), " "));

				if ((maxNumLen - numLen) % 2 == 0) { 
					System.out.print(tabs + seq[i][j] + tabs  + " ");
				} else {
					System.out.print(" " + tabs + seq[i][j] + tabs  + " ");
				}
			}
			System.out.print('\n');
		}

	}

}