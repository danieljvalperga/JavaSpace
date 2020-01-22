import java.util.Arrays;

public class DoSort {
    public static void main(String[] args) {
		int[] sorted = new BubbleSort(new int[]{5, 1, 4, 2, 8}).sort();

		System.out.println("Result: " + Arrays.toString(sorted));
    }
}
