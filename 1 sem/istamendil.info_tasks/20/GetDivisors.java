public class GetDivisors {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Long.parseLong(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
			System.exit(1);
		}

		long num = Integer.parseInt(args[0]);
		long numOperated = num;
		long div = 0;

		for (int i = 2; i <= (num/2); i++) { //num/2 because it's a max possible divisor: num = 2*div
			while (numOperated % i == 0) {
				div += 1;
				numOperated /= i;
			}

			if (div != 0) {
				System.out.print(i + " ");
			}

			div = 0;
		}

		if (numOperated == num) {
			System.out.print(num + " ");
		}

	}

}