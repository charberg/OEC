import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	private static final String DATAFILE = "Testing.txt";
	//private static final String DATACOLUMNS
	
	private int lineNumber = 0;
	private Train[] trains = null;
	
	public void readTrainData() throws IOException{
		
		File dataFile = new File(DATAFILE);
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(dataFile));
		} catch (FileNotFoundException e) {
			System.out.println("");
			System.exit(0);
		}
		
		String in = br.readLine();
		in = br.readLine();
		//Read individual words on a line, regardless of type of white-space
		String[] s = in.split("\\s+");
		
		for (String word:s) {
			System.out.println(word);
		}
		
	}

	public static void main(String[] args) throws IOException {
		Test t = new Test();
		t.readTrainData();
	}

}
