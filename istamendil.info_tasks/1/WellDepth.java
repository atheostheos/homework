public class WellDepth {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please enter time value.");
		} else if (Double.valueOf(args[0]) < 0) {
			System.out.println("Incorrent input format.");
		} else {
			final int G = 10;
			double time = Double.valueOf(args[0]);
			double height = G * Math.pow(time,2) / 2;
			
			System.out.println("Well\'s height is: " + height);
		}
	}
}