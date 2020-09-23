public class InCircleDetermin {

	public static void main(String[] args) {
		if ( (args.length < 5) || (Double.valueOf(args[2]) < 0) ) {
			System.out.println("Incorrect input data.");
		} else {
			double cx = Double.valueOf(args[0]);
			double cy = Double.valueOf(args[1]);
			double r = Double.valueOf(args[2]);
			double x = Double.valueOf(args[3]);
			double y = Double.valueOf(args[4]);

			double distx = Math.abs(cx-x);
			double disty = Math.abs(cy-y);
			double dist = Math.sqrt( Math.pow(distx,2) + Math.pow(disty,2) ); //Distance b/n dot and circle center.

			if (dist <= r) {
				System.out.println("Dot is in the circle.");
			} else {
				System.out.println("Dot is not in the circle.");
			}
		}
	}

}