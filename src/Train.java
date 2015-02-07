
public class Train {
	public enum Colour{RED, YELLOW, GREEN};
	private Integer id, frtLoc, rearLoc, speed;
	private String track, status;
	public Train (Integer id, Integer frtLoc, Integer rearLoc, String track, Integer speed, String status)
	{
		this.id = id;
		this.frtLoc = frtLoc;
		this.rearLoc = rearLoc;
		this.track = track;
		this.speed = speed;
		this.status = status;
	}
	public Integer getFrtLoc() {
		return frtLoc;
	}
	public void setFrtLoc(Integer frtLoc) {
		this.frtLoc = frtLoc;
	}
	public Integer getRearLoc() {
		return rearLoc;
	}
	public void setRearLoc(Integer rearLoc) {
		this.rearLoc = rearLoc;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	
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
