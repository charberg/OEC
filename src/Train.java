import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Train {
	public String colour;	//Red, Yellow, or Green
	private Integer id, frtLoc, rearLoc, speed;
	private String track, status;
	/**
	 * Constructor to create a new Train object containing all the initial data on the train
	 * @param id	The train's ID number
	 * @param frtLoc	The train's front location
	 * @param rearLoc	The train's rear location
	 * @param track	The initial track that the train is on (eg. 2N)
	 * @param speed	The initial speed of the train
	 * @param status	The initial status of the train
	 */
	public Train (Integer id, Integer frtLoc, Integer rearLoc, String track, Integer speed, String status)
	{
		this.id = id;
		this.frtLoc = frtLoc;
		this.rearLoc = rearLoc;
		this.track = track;
		this.speed = speed;
		this.status = status;
	}
	/**
	 * Returns all information on the train as a String
	 * @return The train's information
	 */
	public String toString()
	{
		return "id: " + id + " Front Location: " + frtLoc + " Rear Location: " + rearLoc + " Track: " + track + " Speed: " + speed + " Status: " + status;
	}
	/**
	 * Get the train's front location
	 * @return The front location of the train
	 */
	public Integer getFrtLoc() {
		return frtLoc;
	}
	/**
	 * Set the front location of the train
	 * @param frtLoc The new front location of the train
	 */
	public void setFrtLoc(Integer frtLoc) {
		this.frtLoc = frtLoc;
	}
	/**
	 * Get the train's rear location
	 * @return The rear location of the train
	 */
	public Integer getRearLoc() {
		return rearLoc;
	}
	/**
	 * Set the rear location of the train
	 * @param rearLoc The new rear location of the train
	 */
	public void setRearLoc(Integer rearLoc) {
		this.rearLoc = rearLoc;
	}
	/**
	 * Get the current speed of the train
	 * @return the current speed of the train
	 */
	public Integer getSpeed() {
		return speed;
	}
	/**
	 * Set the speed of the train
	 * @param speed the new speed of the train
	 */
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	/**
	 * Get the current track that the train is running on
	 * @return The current track the train is running on
	 */
	public String getTrack() {
		return track;
	}
	/**
	 * Set the train's track
	 * @param track The track that the train is moving to
	 */
	public void setTrack(String track) {
		this.track = track;
	}
	/**
	 * Get the current status of the train
	 * @return the current status of the train
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Set the status of the train
	 * @param status The new status of the train
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * Get the ID of the train
	 * @return The train's ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Get the hex value of the colour passed into the method
	 * Used in the UI to determine the colour of the train on the map
	 * @param c The colour that we need the hex value for
	 * @return The hex value of the colour
	 */
	public int getColour()
	{
		switch (colour){
		case "RED":
			return 0xFF0000;
		case "YELLOW":
			return 0xFFFF00;
		case "GREEN":
			return 0x00FF00;
		default:
			return 0x0000FF;
		}
	}
	/**
	 * Calculate the distance of the nozone on the train, at the rear of the train
	 * @return The float value of the nozone on the train
	 */
	public double getNoZoneDistance() {
		
		//Use speed in meters/second
		double speedMperS = speed * 1000.0;
		
		if (speed == 0.0) {
			
			return 100.0f;
			
		} else if (speed >= 1.0f && speed <= 30.0f) {
			
			return (-0.000352034) * speedMperS + 100.0;
					
		} else if (speed >= 31.0f && speed <= 50.0f) {
			
			return (-0.00035) * speedMperS + 100.0;
			
		} else if (speed >= 51.0f && speed <= 88.5f) {
			
			return (-0.00035) * speedMperS + 100.0;
			
		} else {
			
			return 0.0f;
			
		}
	
	}
	
	/**
	 * Calculate the slow down zone at the front of the train
	 * @return	The distance in front of the train that the slow down zone starts
	 */
	public double getYellowSafeZoneDistance() {
		
		//Use speed in meters/second
		double speedMperS = speed * 1000.0;
		
		if (speed == 0.0) {
			
			return 100.0;
			
		} else if (speed >= 1.0 && speed <= 30.0) {
			
			return 0.0018 * speedMperS + 100.0;
					
		} else if (speed >= 31.0 && speed <= 50.0) {
			
			return 0.002f * speedMperS + 100.0;
			
		} else if (speed >= 51.0 && speed <= 88.5) {
			
			return 0.0023 * speedMperS + 100.0;
			
		} else {
			
			return 0.0;
			
		}
	
	}
	/**
	 * Calculate the stop zone in front of the train
	 * @return The distance in front of the train that the stop zone starts
	 */
	public double getRedSafeZoneDistance() {
		
		//Use speed in meters/second
		double speedMperS = speed * 1000.0;
		
		if (speed == 0.0) {
			
			return 50.0;
			
		} else if (speed >= 1.0 && speed <= 30.0) {
			
			return 0.0011 * speedMperS + 50.0;
					
		} else if (speed >= 31.0 && speed <= 50.0) {
			
			return 0.00125 * speedMperS + 50.0;
			
		} else if (speed >= 51.0f && speed <= 88.5) {
			
			return 0.0014 * speedMperS + 50.0;
			
		} else {
			
			return 0.0;
			
		}
	
	}
	
	/**
	 * Determine whether train needs to slow down or stop, and write to results file if action is needed
	 * @param t Train ahead 
	 * @throws IOException
	 */
	public void slowStopCheck(Train t) throws IOException {
		
		//Distance to car in front of current train
		double distance = (this.frtLoc - t.getRearLoc())*75.0 + t.getNoZoneDistance();	//Convert block to meters, add no-zone
		
		BufferedWriter out = null;
		try  
		{
		    FileWriter fstream = new FileWriter("results.txt", true); //true tells to append data.
		    out = new BufferedWriter(fstream);
		}
		catch (IOException e)
		{
		    System.err.println("Error: " + e.getMessage());
		}
		
		if(distance < t.getRedSafeZoneDistance()) {
			 this.colour = "RED";
			 out.write("Train " + id + "slows down\n");
		}
		else if(distance < t.getYellowSafeZoneDistance()) {
			this.colour = "YELLOW";
			out.write("Train " + id + "stops\n");
		}
		else {
			this.colour = "GREEN";
		}
		
	}
	
}
