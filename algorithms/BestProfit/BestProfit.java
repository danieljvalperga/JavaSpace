public class BestProfit {
	private int[] input;
	private int[] output;
	private int bestProf = 0;
	private int lowPos;
	private int highPos;

	BestProfit(int[] input) {
		this.input = input;
	}

	public int[] calcBestProfit() {
		for(int i = 0; i < input.length; i++) {
			output = calcBestProfit(i);
		}

		return output;
	}

	public int[] calcBestProfit(int start) {
		for(int i = start + 1; i < input.length; i++) {
			int profit = input[i] - input[start];

			if(profit > bestProf) {
				bestProf = profit;
				lowPos = start;
				highPos = i;
			}
		}

		return new int[] {bestProf, lowPos, highPos};
	}
}
