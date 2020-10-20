import java.util.Scanner;
import java.util.Arrays;

public class LCMCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[2];

		for (int i = 0; i < 2; i++) {
			System.out.print("Please enter " + (i+1) + " number: ");
			while (!sc.hasNextInt()) {
				System.out.println("Incorrect input data.");
				sc.nextLine();
			}
			num[i] = sc.nextInt();
		}

		int max = Math.max(num[0], num[1]);

		int[][] div = new int[2][];
		div[0] = getDivisors(num[0], max);
		div[1] = getDivisors(num[1], max);

		int lcm = 1;
		for (int i = 0 ; i < max; i++) {
			if ( (div[0][i] != 0) || (div[1][i] != 0) ) {
				int maxDiv = Math.max(div[0][i], div[1][i]);
				lcm *= Math.pow( (i+1), maxDiv );
			}
		}

		System.out.println("LCM is: " + lcm);

	}

	public static int[] getDivisors(int num, int len) {
		int[] div = new int[len];
		for (int i = 1; i < num; i++) {
			while((num % (i+1)) == 0) {
				num /= i+1;
				div[i] += 1;
			}

		}
		return div;
	}	
}