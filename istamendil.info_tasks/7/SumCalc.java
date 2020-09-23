public class Sum {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please enter number of elements.");
		} else if (Long.valueOf(args[0]) <= 0) {
			System.out.println("Incorrect input format.");
		} else {
			long n = Long.valueOf(args[0]);
			double sum = 0.0;
			double elem;

			for (int i = 1; i <= n; i++) {
				elem = Math.pow(-1,(i-1)) / Math.pow((2*i-1), 2);
				sum += elem;
			}
			
			System.out.println("The sum of elements is: " + sum);
		}
	}
}