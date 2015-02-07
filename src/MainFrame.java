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
		setSize(800,800);			//TODO: Needs to be changed to screen size
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);	//TODO: Make sure the window cannot be resized
		setLayout(new BorderLayout());
		setTitle("CARLETON SIGNALING SYSTEM CONTROL PANEL - OEC");
		
		MainButtonListener buttonListener = new MainButtonListener(this);
		
		//Bottom Panel (Buttons)
		
		stepButton = new JButton("STEP");
		stepButton.setActionCommand("STEP");
		stepButton.addActionListener(buttonListener);
		
		autoButton = new JButton("AUTO");
		autoButton.setActionCommand("AUTO");
		autoButton.addActionListener(buttonListener);
		
		pauseButton = new JButton("PAUSE");
		pauseButton.setActionCommand("PAUSE");
		pauseButton.addActionListener(buttonListener);
		
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
