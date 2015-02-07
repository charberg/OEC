import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	private static final String DATAFILE = "Testing.txt";
	//private static final String DATACOLUMNS
	
	private int lineNumber = 0;
	private int numTrains = -1;
	private ArrayList<Train> trains = null;
	private File dataFile;
	private BufferedReader br;
	
	public Test() throws IOException{
		dataFile = new File(DATAFILE);
		openFile();
		this.findNumTrains();
		openFile();	//Re-open file for train data reading
		String x = br.readLine();	//Clear the column names row
		
	}
	
	public ArrayList<Train> getTrains() {
		return trains;
	}
	
	private void openFile() {
		
		try {
			br = new BufferedReader(new FileReader(dataFile));
		} catch (FileNotFoundException e) {
			System.out.println("");
			System.exit(0);
		}
		
	}
	
	private void findNumTrains() throws IOException{
		
		if(numTrains == -1){	//If number of trains not yet determined
			int setTime = -1;
			int newTime;
			int lineNum = 0;
			boolean timeCheck = true;
			
			String x = br.readLine();	//Clear the column names line
			x = br.readLine();
			
			while(timeCheck == true){
				//Read individual words on a line, regardless of type of white-space
				
				String[] trainDataLine = x.split("\\s+");
				
				if(setTime == -1){	//If reading the first line
					setTime = Integer.parseInt(trainDataLine[0]);
				}
				
				else {	//If a time value has already been read in
					newTime = Integer.parseInt(trainDataLine[0]);
					if(newTime != setTime) {	//If found new pulse time, stop reading
						timeCheck = false;
						numTrains = lineNum;
					}
					
				}
				
				if(timeCheck == true) {
					lineNum++;
					x = br.readLine();
				}
				
			}
		}
		
	}
	
	public void readTrainData() throws IOException{
		
		String in;
			
			//Read individual words on a line, regardless of type of white-space
		
			
		if(trains == null) {	//If first time reading in train data
			ArrayList<Train> t = new ArrayList<Train>();
			for(int i = 0; i < numTrains; i++) {		
				in = br.readLine();
				String[] trainDataLine = in.split("\\s+");
				t.add(new Train(Integer.parseInt(trainDataLine[1]),
						Integer.parseInt(trainDataLine[2]),
						Integer.parseInt(trainDataLine[3]),
						trainDataLine[4],
						Integer.parseInt(trainDataLine[5]),
						trainDataLine[6]));
				
				trains = t;
			}
		}
			
		else {
			for(int i = 0; i < numTrains; i++) {
				in = br.readLine();
				String[] trainDataLine = in.split("\\s+");
				trains.get(i).setFrtLoc(Integer.parseInt(trainDataLine[2]));
				trains.get(i).setRearLoc(Integer.parseInt(trainDataLine[3]));
				trains.get(i).setTrack(trainDataLine[4]);
				trains.get(i).setSpeed(Integer.parseInt(trainDataLine[5]));
				trains.get(i).setStatus(trainDataLine[6]);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		Test t = new Test();
		for(int i = 0; i < 5; i++) {
			t.readTrainData();
			for(Train test : t.trains) {
				System.out.println(test.toString());
			}
			System.out.println("/////////////////////////////////////");
		}

	}

}
