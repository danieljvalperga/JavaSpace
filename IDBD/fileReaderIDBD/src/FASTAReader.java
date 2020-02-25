import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class FASTAReader {
	private static final String inputPath = "D:\\Documents\\coding_exercises\\IDBD\\SRR1748776.fa";
	private static Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	private static int total = 0;

	public static void main (String[] args) {
		File input = new File(inputPath);
		String line = "", record = "", sequence = "";

		try {
			Scanner sc = new Scanner(input);

			while(sc.hasNextLine()) {
				line = sc.nextLine();

				if(line.startsWith(">")) {
					if(record.length() > 0) { addRecordToTable(record); }
					record = "";
				} else {
					record += line;
				}
			}

			genOutput();

		} catch(Exception e) {
			System.out.println("Encountered unexpected error: ["+e.getMessage()+"]");
		}
	}

	private static void addRecordToTable(String record) {
		String[] kmers = record.split("(?<=\\G.{25})");

		for(String kmer: kmers) {
			if(kmer.length() == 25) {
				if(!kmer.matches("^[ATCG]+")) {
					//System.out.println("### Encountered bad sequence data: ["+kmer+"]");
					continue;
				}

				total++;
				if (!ht.containsKey(kmer)) {
					ht.put(kmer, 1);
				} else {
					ht.put(kmer, ht.get(kmer) + 1);
				}
			}
		}

	}

	private static void genOutput() {
		int largest = 0, val = 0;
		String largestKey = "";

		for(String key: ht.keySet()) {
			val = ht.get(key);
			if(val > largest) {
				largestKey = key;
				largest = val;
			}
		}

		System.out.println("### Distinct kmer count ["+ht.keySet().size()+"]");
		System.out.println("### Total kmer count ["+ total +"]");
		System.out.println("### kmer with highest count ["+largestKey+"] count ["+largest+"]");
	}
}
