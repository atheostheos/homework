import java.util.Scanner;
import java.util.Arrays;
public class FindSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//___________________Arrays' length___________________
		int[] n = new int[2];

		for (int i = 0; i < 2; i++) {
			System.out.print("Enter " + (i+1) + " array\'s length: ");
			while (!sc.hasNextInt()) {
				sc.next(); //skip input if not int
				System.out.print("Incorrect input format: ");
			}
			n[i] = sc.nextInt();
		}
		//___________________Arrays' values___________________
		int[][] arr = new int[2][];
		arr[0] = new int[n[0]];
		arr[1] = new int[n[1]];

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter " + (i+1) + " array\'s elements.");

			for (int j = 0; j < n[i]; j++) {
					System.out.print(j + ": ");
					while (!sc.hasNextInt()) {
						sc.next(); //skip input if not int
						System.out.print("Incorrect input format: ");

					}
					arr[i][j] = sc.nextInt();
				}
		}
		//___________________Finding match____________________
		int count = 0;
		int index = -1;
		boolean flagIndexNotFound = true;
		boolean flagIsMatch = true;

		if (arr[0].length > arr[1].length) {
			System.out.println("No match found.");
			System.exit(0);
		}

		int tryMatchCycles = arr[1].length-arr[0].length+1; // amount of cycles needed to check all possible matches

		for (int i = 0; (i < tryMatchCycles) && flagIndexNotFound; i++) {
			if (arr[1][i] == arr[0][0]) { //if first elements match check other elements
				
				for (int j = i; (j < (i + arr[0].length) ) && flagIsMatch; j++) { 
					if (arr[1][j] == arr[0][j-i]) {
						count += 1;
					} else {
						count = 0;
						flagIsMatch = false;
					}
				}

				if (count == arr[0].length) {
					index = i;
					flagIndexNotFound = false;
				}

				flagIsMatch = true;
			}
		}

		if (index != -1) {
			System.out.println("Match found, index: " + index);
		} else {
			System.out.println("No match found.");
		}

	}

}