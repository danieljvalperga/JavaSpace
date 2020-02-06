import java.util.Arrays;

public class TestBestProfit {
	private static int[][] testInputs = {
			new int[]{30, 3, 2, 1, 8, 9, 12},
			new int[]{30, 3, 2, 1, 8, 14, 9, 12}
	};

	public static void main(String[] args) {
		Arrays.stream(testInputs).forEach(arr -> {
			System.out.println("### Result: " + Arrays.toString(new BestProfit(arr).calcBestProfit()));
		});
	}
}
