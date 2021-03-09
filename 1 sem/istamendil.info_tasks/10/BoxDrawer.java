public class BoxDrawer {

	public static void main(String[] args) {
		if ( (args.length < 1) || (Integer.parseInt(args[0]) < 1) ) {
			System.out.println("Incorrect input data.");
		} else {
			int n = Integer.parseInt(args[0]);
			String ends = "";
			String middle = "";

			for (int i = 0; i < n; i++) {
				if ( (i==0) || (i==n-1) ){
					middle += "* ";
				} else {
					middle += "  ";
				}
				ends += "* ";
			}

			for (int i = 0; i < n; i++) {
				if ( (i==0) || (i==n-1) ){
					System.out.println(ends);
				} else {
					System.out.println(middle);
				}
			}
		}
	}

}