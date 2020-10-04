import java.util.Scanner;

public class NodCalc {

	public static int getNodEvclid(int num1, int num2) {
		while (num1 != num2) {
			if (num1 > num2) {
				num1 -= num2;
			} else {
				num2 -= num1;
			}
		}

		return num1;
	}

	public static int getNodIter(int num1, int num2) {
		int[] div1 = new int[num1]; // div1 & and div2 are divisors of num1 & num2:
		int[] div2 = new int[num2];	// index - divisor, value - number of divisors.

		for (int i = 2; i < div1.length; i++) {
			while (num1 % i == 0) {
				div1[i] += 1;
				num1 /= i;
			}
		} 

		for (int i = 2; i < div2.length; i++) {
			while (num2 % i == 0) {
				div2[i] += 1;
				num2 /= i;
			}
		}

		int nod = 1;
		for (int i = 2; i < Math.min(div1.length, div2.length); i++) {
			if (Math.min(div1[i],div2[i]) != 0) {
				nod *= Math.pow( i, Math.min(div1[i],div2[i]) );
			}
		}

		return nod;

	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] num = new int[2];
		long[] time = new long[2];
		
		for (int i = 0; i < 2; i++) {
			System.out.print("Please enter " + (i + 1) + " number: ");
			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.print("Incorrect input format: ");
			}
			num[i] = sc.nextInt();
		}

		time[0] = System.currentTimeMillis();
		System.out.print("NOD by Euclid algorithm: " + getNodEvclid(num[0], num[1]));
		time[0] = System.currentTimeMillis() - time[0];
		System.out.println("  | time: " + time[0] + ".");

		time[1] = System.currentTimeMillis();
		System.out.print("NOD by iterations: " + getNodIter(num[0], num[1]));
		time[1] = System.currentTimeMillis() - time[1];
		System.out.println("  | time: " + time[1] + ".");

	}

}