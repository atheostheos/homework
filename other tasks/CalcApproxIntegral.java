import java.util.Scanner;

public class CalcApproxIntegral {

	public static void main(String[] args) {

		//_________Data input_________
		Scanner sc = new Scanner(System.in);
		double[] x = new double[2];
		int n;
		String method;

		System.out.println("Function: sin(x) + 1.");

		for(int i = 0; i < 2; i++) {
			System.out.printf("Enter %d coordinate: ", (i+1));
			while (!sc.hasNextDouble()) {
				System.out.println("Incorrect input data.");
				sc.nextLine();
			}
			x[i] = sc.nextDouble();
		}
		sc.nextLine(); //read exessive \n after nextDouble function
		
		System.out.print("Enter amount of divisions (affects the accuracy of calculation): ");
			while (!sc.hasNextInt()) {
				System.out.println("Incorrect input data.");
				sc.nextLine();
			}
		n = Integer.parseInt(sc.nextLine());

		System.out.print("Choose calculating method (rectangle, trapezium, simpson): ");
		method = sc.nextLine().toLowerCase();


		//_________Integral calculation_________
		double dx = (x[1] - x[0]) / n;
		double integral = 0.0;

			switch (method) {
				case "rectangle":
					integral = calcAreaRect(x[0],x[1], dx);
					break;

				case "trapezium":
					integral = calcAreaTrapez(x[0],x[1] ,dx);
					break;

				case "simpson":
					integral = calcAreaParab(x[0], x[1], dx, n);
					break;

				default:
					System.out.printf("Function %s not found. Abort.\n", method);
					System.exit(1);
			}

		System.out.printf("Calculated integral is: %.2f \n", integral);

	}

	public static double calcAreaRect(double x0, double x1, double dx) {
		double integral = 0.0;
		while (x0 < x1) {
			integral += func(x0) * dx;
			x0 += dx;
		}
		return integral;
	}


	public static double calcAreaTrapez(double x0, double x1, double dx) {
		double integral = 0.0;
		while (x0 < x1) {
			integral += 0.5 * (func(x0) + func(x0 + dx)) * dx;
			x0 += dx;
		}
		return integral;
	}

	public static double calcAreaParab(double x0, double x1, double dx, double n) {
		double integral = func(x0) + func(x1);
		double coef = (x1 - x0) / (3*n);
		int i = 1;
		while ( (x0 + dx) < (x1 - dx)) {
			integral += (i % 2 != 0) ? 4*func(x0) : 2*func(x0);
			x0 += dx;
		}
		integral = coef * integral;
		return integral;	
	}

	public static double func(double x) {
		return (Math.sin(x) + 1);
	}



}