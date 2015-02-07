import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton stepButton, autoButton, pauseButton,zoomIn,zoomOut, quitButton;
	private JLabel trainStats;
	private TrainDataReader data;
	
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);			//TODO: Needs to be changed to screen size
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);	//TODO: Make sure the window cannot be resized
		setUndecorated(true);
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
		
		quitButton = new JButton("QUIT");
		quitButton.addActionListener(buttonListener);
		quitButton.setActionCommand("QUIT");
		
		JPanel topPanel = new JPanel();
		topPanel.add(trainStats);
		topPanel.add(quitButton);
		
		add(topPanel, BorderLayout.NORTH);
		
		//Middle Panel (Trains)
		
		TrainGridPanel midPanel = new TrainGridPanel(334,267);
		add(midPanel, BorderLayout.CENTER);
		
		
		//Right Panel
		
		zoomIn = new JButton("ZOOM +");
		zoomIn.setActionCommand("zoomIn");
		zoomIn.addActionListener(buttonListener);
		
		zoomOut = new JButton("ZOOM -");
		zoomOut.setActionCommand("zoomOut");
		zoomOut.addActionListener(buttonListener);
		
		JPanel leftPanel = new JPanel();
		leftPanel.add(zoomIn);
		leftPanel.add(zoomOut);
		
		add(leftPanel, BorderLayout.EAST);
		try {
			data = new TrainDataReader();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			data.readTrainData();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		setVisible(true);
	}
	
	public void updateData()
	{
		try {
			data.readTrainData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		
	}

}
