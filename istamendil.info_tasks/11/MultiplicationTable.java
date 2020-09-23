public class MultiplicationTable {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.valueOf(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		}  else {
			int n = Integer.valueOf(args[0]);

			for (int i=1; i <= n; i++) {
				for (int j=1; j <= n; j++) {
					System.out.print(String.valueOf(i*j) + ' ');
				}
				System.out.print("\n");
			}
		}
	}

}