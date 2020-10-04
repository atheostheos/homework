public class IndexOf {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Incorrect input data.");
		} else {
			String str1 = args[0];
			String str2 = args[1];

			if (str1.length() < str2.length()) {
				System.out.println("No match found.");
			} else {

				int count = 0;
				int index = -1;
				boolean flagIndexNotFound = true;
				boolean flagIsMatch = true;

				int tryMatchCycles = str1.length()-str2.length()+1; // amount of cycles needed to check all possible matches

				for (int i = 0; (i < tryMatchCycles) && flagIndexNotFound; i++) {
					if (str1.charAt(i) == str2.charAt(0)) { //if first chars match check other chars
						
						for (int j = i; (j < (i + str2.length()) ) && flagIsMatch; j++) { 
							if (str1.charAt(j) == str2.charAt(j-i)) {
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

}