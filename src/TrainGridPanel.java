import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Main Panel for center of the application showing all trains and routes.
 *
 */
public class TrainGridPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private GridBox[][] grid;
	private int sizeX, sizeY;
	
	public TrainGridPanel(int size_X, int size_Y){
		sizeX = size_X;
		sizeY = size_Y;
		grid = new GridBox[sizeY][sizeX];
		setLayout(new GridLayout(sizeY,sizeX));
		for(int i=0;i<sizeY;i++){
			for(int j=0;j<sizeX;j++){
				//TODO: add action listener to gridbox
				grid[i][j] = new GridBox(i,j,"empty");
				add(grid[i][j]);
			}
		}
		//System.out.println(sizeX);
		for(int i=0;i<200;i++){
			//System.out.println(i);
			grid[20][i].setStatus("route");
			grid[40][i].setStatus("route");
		}
		
		
		for(int i=0;i<334;i++){
			//System.out.println(i);
			grid[200][i].setStatus("route");
			grid[220][i].setStatus("route");
		}
		
		for(int i=0; i<267; i++){
			grid[i][100].setStatus("route");
			grid[i][120].setStatus("route");
		}
		
		//setVisible(true);
	}
	
	public void updateTrains(int front, int rear, int id)
	{
		
		if(1101<=front&&front<=1301){
			grid[20][1301-front].setStatus("train");
			grid[20][1301-rear].setStatus("train");
		}
		else if(1501<=front&&front<=1701){
			grid[40][200-(1701-front)].setStatus("train");
			grid[40][200-(1701-rear)].setStatus("train");
		}
		else if(2101<=front&&front<=2368){
			grid[2368-front][100].setStatus("train");
			grid[2368-rear][100].setStatus("train");
		}
		else if(2501<=front&&front<=2768){
			grid[267-(2768-front)][120].setStatus("train");
			grid[267-(2768-rear)][120].setStatus("train");			
		}
		else if(3101<=front&&front<=3435){
			grid[200][3435-front].setStatus("train");
			grid[200][3435-rear].setStatus("train");
		}
		else if(3501<=front&&front<=3835){
			grid[220][334-(3835-front)].setStatus("train");
			grid[220][334-(3835-rear)].setStatus("train");			
		}
	}
	
	

}
