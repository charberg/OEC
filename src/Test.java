import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
	
	private static final String DATAFILE = "Testing.txt";
	
	public void readData(){
		
		File dataFile = new File(DATAFILE);
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
		} catch (FileNotFoundException e) {
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("David Test Push");
	}

}
