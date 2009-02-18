package MTUI_WT;

import java.awt.*;

import javax.swing.*;

public class ProcessingFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public ProcessingFrame(String aTitle){
		super(aTitle);
		
		// Menubar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemNew = new JMenuItem("New");
		menuFile.add(menuItemNew);
		
		//frame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//applet
		ProcessingApplet app = new ProcessingApplet(new Dimension(this.getWidth(), (int) (this.getWidth()-menuBar.getBounds().getHeight())));
		app.init();
		app.start();
		
		JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(app);
				
		this.getContentPane().add(pane);
		this.setVisible(true);
	}
	

}
