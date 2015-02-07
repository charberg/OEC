import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MainButtonListener implements ActionListener{
	
	private MainFrame main;
	
	public MainButtonListener(MainFrame frame){
		main = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton srcButton = (JButton) arg0.getSource();
		if(srcButton.getActionCommand().equals("STEP")){
			main.updateData();
		}else if(srcButton.getActionCommand().equals("AUTO")){
			
		}else if(srcButton.getActionCommand().equals("PAUSE")){
		
		}else if(srcButton.getActionCommand().equals("zoomIn")){
			
		}else if(srcButton.getActionCommand().equals("zoomOut")){
			
		}else if(srcButton.getActionCommand().equals("QUIT")){
			System.exit(0);
		}else{
			System.out.println("Unrecognized Button Press");
		}
	}

}
