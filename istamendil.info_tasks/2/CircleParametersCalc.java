public class CircleParameters {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please enter radius.");
		} else if (Double.valueOf(args[0]) < 0) {
			System.out.println("Incorrect input format.");
		} else {
			double radius = Double.valueOf(args[0]);
			double length = 2*Math.PI*radius;
			double area = Math.PI*Math.pow(radius,2);
			
			System.out.println("Circle\'s length is: " + Math.round(length*100.0)/100.0);
			System.out.println("Circle\'s area is: " + Math.round(area*100.0)/100.0);
		}
	}
}