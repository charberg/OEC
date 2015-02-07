import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GridBoxListener implements ActionListener{

	private MainFrame main;
	
	public GridBoxListener(MainFrame frame){
		main = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GridBox box = (GridBox)e.getSource();
		if(box.getBoxColour().equals("green") || box.getBoxColour().equals("red") || box.getBoxColour().equals("red") || box.getBoxColour().equals("grey") || box.getBoxColour().equals("yellow") || box.getBoxColour().equals("pruple")){
			//main.trainInfo("TRAIN DATA");
		}
		
	}

}
