public class ShowPascalTriangleFormat {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.parseInt(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
			System.exit(1);
		}


		int size = Integer.parseInt(args[0]);
		long maxNum = getBinomCoef(size, size/2);
		int maxLen = (int) Math.log10(maxNum) + 1;

		for (int n = 0; n < size; n++) {
			for (int s = 0; s < (maxLen+1)*(size-1 - n)/2; s++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= n; k++) {
				long elem = getBinomCoef(n, k);
				System.out.printf("%-" + (maxLen+1) + "d", elem);
			}
			System.out.print('\n');
		}

	}

	public static long getBinomCoef(int n, int k) {
		return getFact(n) / (getFact(n-k) * getFact(k));
	}

	public static long getFact(int num) {
		long fact = 1;
		for (int i = 2; i <= num; i++) {
			fact*= i;
		}
		return fact;
	}
}