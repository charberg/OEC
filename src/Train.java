
public class Train {
	public enum Colour{RED, YELLOW, GREEN};
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
	public int getColour(Train.Colour c)
	{
		switch (c){
		case RED:
			return 0xFF0000;
		case YELLOW:
			return 0xFFFF00;
		case GREEN:
			return 0x00FF00;
		default:
			return 0x0000FF;
		}
	}
	/**
	 * Calculate the distance of the nozone on the train, at the rear of the train
	 * @return The float value of the nozone on the train
	 */
	public float getNoZoneDistance() {
		
		if (speed == 0.0f) {
			
			return 100.0f;
			
		} else if (speed >= 1.0f && speed <= 30.0f) {
			
			return (-0.000352034f) * speed + 100.0f;
					
		} else if (speed >= 31.0f && speed <= 50.0f) {
			
			return (-0.00035f) * speed + 100.0f;
			
		} else if (speed >= 51.0f && speed <= 88.0f) {
			
			return (-0.00035f) * speed + 100.0f;
			
		} else {
			
			return 0.0f;
			
		}
	
	}
	
	/**
	 * Calculate the slow down zone at the front of the train
	 * @return	The distance in front of the train that the slow down zone starts
	 */
	public float getYellowSafeZoneDistance() {
		
		if (speed == 0.0f) {
			
			return 100.0f;
			
		} else if (speed >= 1.0f && speed <= 30.0f) {
			
			return 0.0018f * speed + 100.0f;
					
		} else if (speed >= 31.0f && speed <= 50.0f) {
			
			return 0.002f * speed + 100.0f;
			
		} else if (speed >= 51.0f && speed <= 88.0f) {
			
			return 0.0023f * speed + 100.0f;
			
		} else {
			
			return 0.0f;
			
		}
	
	}
	/**
	 * Calculate the stop zone in front of the train
	 * @return The distance in front of the train that the stop zone starts
	 */
	public float getRedSafeZoneDistance() {
		
		if (speed == 0.0f) {
			
			return 50.0f;
			
		} else if (speed >= 1.0f && speed <= 30.0f) {
			
			return 0.0011f * speed + 50.0f;
					
		} else if (speed >= 31.0f && speed <= 50.0f) {
			
			return 0.00125f * speed + 50.0f;
			
		} else if (speed >= 51.0f && speed <= 88.0f) {
			
			return 0.0014f * speed + 50.0f;
			
		} else {
			
			return 0.0f;
			
		}
	
	}
	
}
