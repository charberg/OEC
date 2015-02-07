import java.awt.Color;

import javax.swing.JPanel;

/** Panel that goes inside of the TrainGridPanel **/
public class GridBox extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String colour;
	private int x,y;
	
	public GridBox(int xpos, int ypos, String type){
		if(type.equals("route")){
			setBackground(Color.CYAN);
			colour = "cyan";
		}else if(type.equals("train")){
			setBackground(Color.RED);
			colour = "red";
		}else{
			setBackground(Color.WHITE);
			colour = "white";
		}
		
		x = xpos;
		y = ypos;
		
		
	}
	
	public void setStatus(String status){
		
		if(status.equals("Running")){
			this.setBackground(Color.GREEN);
			colour = "green";
		}else if(status.equals("Idling")){
			this.setBackground(new Color(150,150,150));
			colour = "grey";
		}else if(status.equals("OSS")){
			this.setBackground(new Color(163,0,227));
			colour = "purple";
		}else if(status.equals("EMR")){
			this.setBackground(Color.RED);
			colour = "red";
		}else if(status.equals("Slow")){
			this.setBackground(Color.YELLOW);
			colour = "yellow";
		}else{
			this.setBackground(Color.BLUE);
			colour = "blue";
		}
		
	}
	
	public String getColour(){
		return colour;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
}
