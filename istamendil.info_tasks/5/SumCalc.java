public class SumCalc {
	public static void main(String[] args) {
		if ( (args.length < 2) || (Integer.valueOf(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		} else {
			int n = Integer.valueOf(args[0]);
			double x = Double.valueOf(args[1]);
			double sum = (n-1) + x/n; //last element calculated if n > 1

			for (int i = n-2; i >= 1; i--) { //other elements calculated (from last to first)
				sum = i + x/sum;
			}
			if (n == 1) sum = 1;

			System.out.println("Calculated sum is: " + sum);
		}
	}
}