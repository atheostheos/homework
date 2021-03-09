public class MultiplicationTable {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.parseInt(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		}  else {
			int n = Integer.parseInt(args[0]);
			int maxLength = String.valueOf(n*n).length(); //length of the maximum nubmer

			System.out.println('\n');

			for (int i=1; i <= n; i++) {
				for (int j=1; j <= n; j++) {
					int length = String.valueOf(i*j).length();
					
					for (int k=1; k <= maxLength-length; k++) {
						System.out.print(" ");
					}

					System.out.print(String.valueOf(i*j));
					System.out.print(" ");
				}
				System.out.print("\n");
			}
		}
	}

}