public class CosCalc {

	public static void main(String[] args) {
		if ( (args.length < 2) || (Integer.parseInt(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		} else {
			int n = Integer.parseInt(args[0]);
			double x = Double.parseDouble(args[1]);
			double res = Math.cos(x);

			for (int i = 1; i <= (n-1); i++ ) {
				res = Math.cos(x + res);
			}

			System.out.println("Calculated result is: " + res);
		}
	}

}