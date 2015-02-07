import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Main Panel for center of the application showing all trains and routes.
 *
 */
public class TrainGridPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public TrainGridPanel(int sizeX, int sizeY){
		
		setLayout(new GridLayout(sizeX,sizeY));
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				//TODO: add action listener to gridbox
				add(new GridBox(i,j,"empty"));
			}
		}
		
		//setVisible(true);
	}
	
	
	
	

}
