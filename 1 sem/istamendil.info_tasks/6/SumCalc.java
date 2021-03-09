public class SumCalc {
	public static int getFact(int base) {
		int fact = 1;
		for (int i = 2; i<= base; i++) {
			fact *= i;
		}
		return fact;
	}

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.valueOf(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		} else {
			int n = Integer.valueOf(args[0]);
			double sum = 0;

			for (int m = 1; m <= n; m++) {
				sum += Math.pow( getFact(m-1), 2 ) / getFact(2*m);
			}

			System.out.println("Calculated sum is: " + sum);
		}
	}
}