import java.util.Scanner;

public class IndexOfIgnoreCase {

	public static char toLowerCase(char ch) {
		if ( (ch >= 'A') && (ch <= 'Z') ) {
			ch +=32;
		}
		return ch;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter text: ");
		String str1 = sc.nextLine();
		System.out.print("Enter text being searched: ");
		String str2 = sc.nextLine();

		if (str1.length() < str2.length()) {
			System.out.println("No match found.");
		} else {

			int count = 0;
			int index = -1;
			boolean flagIndexNotFound = true;
			boolean flagIsMatch = true;

			int tryMatchCycles = str1.length()-str2.length()+1; // amount of cycles needed to check all possible matches

			for (int i = 0; (i < tryMatchCycles) && flagIndexNotFound; i++) {
				if ( toLowerCase(str1.charAt(i)) == toLowerCase(str2.charAt(0)) ) { //if first chars match check other chars
					for (int j = i; (j < (i + str2.length()) ) && flagIsMatch; j++) { 
						if ( toLowerCase(str1.charAt(j)) == toLowerCase(str2.charAt(j-i)) ) {
							count += 1;
						} else {
							count = 0;
							flagIsMatch = false;
						}
					}

					if (count == str2.length()) {
						index = i;
						flagIndexNotFound = false;
					}

					flagIsMatch = true;
				}
			}

			if (index != -1) {
				System.out.println("Match found, index: " + index);
			} else {
				System.out.println("No match found.");
			}
		}
	}

}