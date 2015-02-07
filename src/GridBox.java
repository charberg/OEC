import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Panel that goes inside of the TrainGridPanel **/
public class GridBox extends JButton{
	
	private static final long serialVersionUID = 1L;
	private String boxColour;
	private int xpos,ypos;
	
	public GridBox(int x_pos, int y_pos, String type){
		
		if(type.equals("route")){
			this.setBackground(Color.CYAN);
			boxColour = "cyan";
		}else if(type.equals("train")){
			setBackground(Color.RED);
			boxColour = "red";
		}else{
			setBackground(Color.WHITE);
			boxColour = "white";
		}
		
		//setBorder(BorderFactory.createLineBorder(Color.black));
		
		xpos = x_pos;
		ypos = y_pos;
		
		//setVisible(true);
	}
	
	public void setStatus(String status){
		
		if(status.equals("Running")){
			this.setBackground(Color.GREEN);
			boxColour = "green";
		}else if(status.equals("Idling")){
			this.setBackground(new Color(150,150,150));
			boxColour = "grey";
		}else if(status.equals("OSS")){
			this.setBackground(new Color(163,0,227));
			boxColour = "purple";
		}else if(status.equals("EMR")){
			this.setBackground(Color.RED);
			boxColour = "red";
		}else if(status.equals("Slow")){
			this.setBackground(Color.YELLOW);
			boxColour = "yellow";
		}else{
			this.setBackground(Color.BLUE);
			boxColour = "blue";
		}
		
	}
	
	public String getBoxColour(){
		return boxColour;
	}
	
	public int getXPos(){
		return xpos;
	}
	
	public int getYPos(){
		return ypos;
	}
	
	
}
