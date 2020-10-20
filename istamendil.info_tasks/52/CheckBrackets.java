public class CheckBrackets {

	public static void main(String[] args) {
		String str = String.valueOf(args[0]);

		System.out.println(checkBrackets(str));

	}

	public static boolean checkBrackets(String line) {
		char[] ch = line.toCharArray();

		return checkBrackets(ch, 0, 0);

	}

	public static boolean checkBrackets (char[] ch, int i, int nesting) { 
		// nesting - amount of open brackets in current bracket + 1, e.g. ((())) - 3
		if (i == ch.length-1) { // check of last element
			switch (ch[i]) {

			case ('('):
				return false;

			case (')'):
				return (nesting == 1) ? true : false;


			default:
				return (nesting == 0) ? true : false;
			}
		}
		
		switch (ch[i]) {

			case ('('):
				return true & checkBrackets(ch, i+1, nesting+1);


			case (')'):
				return ( (nesting-1) < 0 ) ? false : true & checkBrackets(ch, i+1, nesting-1);

			default:
				return (true & checkBrackets(ch, i+1, nesting));
		}


	}
}