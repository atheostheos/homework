public class WallisPiCalc {
	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.valueOf(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		} else {
			int n = Integer.valueOf(args[0]);
			double prod = 1.0;

			for (int i = 1; i <= n; i++) {
				prod *= Math.pow(2*i,2) / ((2*i-1) * (2*i+1));
			}
			prod *= 2;
			
			System.out.print("Calculated Pi is: " + prod);
		}
	}
}	