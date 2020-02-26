// { Driver Code Starts
import java.util.Scanner;

class PrintPattern
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println("### T: ["+t+"]");
		while(t>0)
		{
			int n = sc.nextInt();
			GfG g = new GfG();
			g.printPat(n);
			System.out.println();

			t--;
		}
	}
}// } Driver Code Ends
class GfG
{
	void printPat(int n)
	{
		String out = "";
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