import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton stepButton, autoButton, pauseButton;
	private JLabel trainStats;
	
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setTitle("CARLETON OEC");
		
		//Bottom Panel (Buttons)
		
		stepButton = new JButton("STEP");
		stepButton.setActionCommand("STEP");
		
		autoButton = new JButton("AUTO");
		autoButton.setActionCommand("AUTO");
		
		pauseButton = new JButton("PAUSE");
		pauseButton.setActionCommand("PAUSE");
		
		JPanel bottomPanel = new JPanel();
		
		bottomPanel.add(stepButton);
		bottomPanel.add(autoButton);
		bottomPanel.add(pauseButton);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		//Top Panel (Label)
		
		trainStats = new JLabel("TRAIN DATA HERE");
		
		JPanel topPanel = new JPanel();
		topPanel.add(trainStats);
		
		add(topPanel, BorderLayout.NORTH);
		
		//Middle Panel (Trains)
		
		JPanel midPanel = new JPanel();
		
		add(midPanel, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		MainFrame main = new MainFrame();

	}

}
