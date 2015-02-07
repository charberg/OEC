
public class Train {
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
}
