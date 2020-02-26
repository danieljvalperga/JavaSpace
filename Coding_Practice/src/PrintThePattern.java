public class PrintThePattern {
	private String out = "";

	void printPat(int n) throws Exception
	{
		// ------ INPUT VALIDATION ------ //
		//1 <= T <= 20
		if(1 > n || n > 40) {
			throw new Exception("Unexpected input value: ["+n+"]");
		}
		// ------ ---------------- ------ //

		int times = n;
		while(times > 0) {
			int val = n;
			while (val > 0) {
				int count = times;
				while (count > 0) {
					out += Integer.toString(val) + " ";
					count--;
				}
				val--;
			}
			out += "$";
			times--;
		}

		System.out.println(out);
	}
}
