import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class FASTAReader_v2 {
	private static final String path = "D:\\Documents\\coding_exercises\\IDbyDNA\\SRR1748776.fa";
	private static Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	private static int total = 0;		//kmers added
	private static int readCount = 0;	//Reads encountered

	public static void main (String[] args) {
		int count = 0;
		File input = new File(path);
		String line = "", record = "", sequence = "";

		try {
			Scanner sc = new Scanner(input);

			while(sc.hasNextLine() && count < 50) {
				count++;
				line = sc.nextLine();
				//System.out.println("### COUNT["+count+"] LINE["+line+"]");

				if(line.startsWith(">")) {
					//System.out.println("### GOT HEADER["+line+"]");
					readCount++;
					if(record.length() > 0) { addRecordToTable(record); }
					record = "";
				} else {
					record += line;
				}

			}

			count = 0;
			doOutput();

		} catch(Exception e) {
			System.out.println("ERROR: Encountered error: ["+e.getMessage()+"]");
		}
	}

	private static void addRecordToTable(String record) {
		String[] kmers = record.split("(?<=\\G.{25})");
		int bcount = 0;	//bad record

		for(String kmer: kmers) {
			if(kmer.length() == 25) {
				if(!kmer.matches("^[ATCG]+")) {
					System.out.println("### Encountered bad sequence data: ["+kmer+"]");
					bcount++;
					continue;
				}
				System.out.println("### ADDING KMER TO TABLE: [" + kmer + "]");
				total++;
				if (!ht.containsKey(kmer)) {
					ht.put(kmer, 1);
				} else {
					ht.put(kmer, ht.get(kmer) + 1);
				}
			}
		}

	}

	private static void doOutput() {
		int largest = 0;		//Current largest number of repeating sequences seen
		int largestSize = 0;	//Number of entries with the same largest size
		int val = 0;			//Actual largest number of repeating sequences seen
		ArrayList largestKeys = new ArrayList<String>();

		System.out.println("### DISTINCT COUNT: ["+ht.keySet().size()+"]");
		System.out.println("### TOTAL COUNT["+ total +"]");

		for(String key: ht.keySet()) {
			val = ht.get(key);
			if(val > largest) {
				largest = val;
				largestKeys.clear();
				largestKeys.add(key);
				largestSize = 0;
			} else if (val == largest) {
				largestSize++;
				largestKeys.add(key);
			}
		}

		System.out.println("### KMER WITH HIGHEST COUNT["+largestKeys.get(0)+"] COUNT["+largest+"]");
	}
}
