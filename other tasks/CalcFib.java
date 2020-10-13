import java.util.Arrays;

public class CalcFib {

	public static void main(String[] args) {
		if ((args.length < 1) || (Integer.parseInt(args[0]) < 1)) {
			System.out.println("Incorrect input data");
		}

		int n = Integer.parseInt(args[0]);
		
		long time1 = System.nanoTime();
		System.out.print("Result by recursive algorithm: " + calcFibRec(n));
		time1 = System.nanoTime() - time1;
		System.out.printf("  |time %d ns\n", time1);

		long time2 = System.nanoTime();
		System.out.print("Result by algorithm using an array: " + calcFibAr(n));
		time2 = System.nanoTime() - time2;
		System.out.printf("  |time %d ns\n", time2);

	}

	public static int calcFibRec(int n) {
		if (n < 3) {
			return 1;
		}
		return calcFibRec(n-1) + calcFibRec(n-2);
	}


	public static int calcFibAr (int n) {
		int[] ar = new int[n];
		ar[0] = 1;
		ar[1] = 1;
		calcFibAr(2, ar);
		return ar[n-1];
	}

	public static int calcFibAr(int n, int[] ar) {
		if (n >= ar.length) return 0;
		
		ar[n] = ar[n-1] + ar[n-2];
		return calcFibAr(n+1, ar);
	}
}