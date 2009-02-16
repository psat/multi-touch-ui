import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class MainFrame {

	public static void main(String[] args) {
		new MainFrame();
	}
	public MainFrame(){
		
		this.BuildFrame();
	}
	void BuildFrame(){
		
		JFrame frame = new JFrame("Frame and applet");
		frame.setLayout(new GridLayout(0,1));
		
		// Menubar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemNew = new JMenuItem("New");
		menuFile.add(menuItemNew);
		
		//frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(40,40);
		frame.setSize(800, 600);
		
		//applet
		System.out.println(frame.getBounds().getWidth()+"\t"+(frame.getBounds().getHeight()-menuBar.getBounds().getHeight()));
		MyProcessingSketch app = new MyProcessingSketch(frame.getBounds().getWidth(), frame.getBounds().getHeight()-menuBar.getBounds().getHeight());
		app.init();
		app.start();
		
	    JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(app);
		
		
		//frame.getContentPane().add(toolBar);
		frame.getContentPane().add(pane);
		
	
		
		frame.setVisible(true);
	}
}
