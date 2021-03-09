public class IsDotInFunction {
	
	public static void main(String[] args) {

		final double EPS = 1e-10;
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double y1 = func(x);

		if (Math.abs(y1 - y) <= EPS) {
			System.out.println("Dot is in function.");
		} else {
			System.out.println("Dot is not in function");
		}
	}

	public static double func(double x) {
		return Math.pow(x,3);
	}
}