import java.util.Random;
import java.util.Arrays;

public class ArrSortMean {

	public static void main(String[] args) {

		int n = 10;
		Random rand = new Random();
		int[] arr = new int[n];
		int temp;

		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(29)+2;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(i+ "| "+Arrays.toString(arr));
		}

		double mean = 1;
		for (int i = 0; i < n; i++) {
			mean *= arr[i];
		}


		mean = Math.pow(mean, 1.0/n);
		System.out.println("Mean value is: " + Math.round(mean) );
	}
}