package MTUI.Processing;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import MTUI.Constants.*;
import MTUI.Processing.ProcessingApplet;

public class ProcessingFrame extends JFrame{

private static final long serialVersionUID = 1L;
	
	protected ProcessingApplet app;
	
	public ProcessingFrame(String aTitle){
		super(aTitle);
		
		this.setLayout(new GridLayout(0,1));
		
		
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
		app = new ProcessingApplet();
		app.init();
		app.start();
		
		this.setBounds(AppletConst.APPLET_X,AppletConst.APPLET_Y,AppletConst.APPLET_WIDTH, AppletConst.APPLET_HEIGHT);
		JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(app);
				
		this.getContentPane().add(pane);
		this.setVisible(true);
		
	}
	public ProcessingApplet getProcessingApplet(){
		
		return this.app;
	}
	@Override
	public void setBounds(int x, int y, int width, int height){
		
		//work around on mac
		try{
			app.setBounds(x, (int) (y - this.getJMenuBar().getBounds().getHeight()), width, height);
		} catch(Exception ex){}
	
		super.setBounds(x, y, width, height);
	}
	@Override
	public void setBounds(Rectangle r){
		app.setBounds((int)r.getX(), (int) (r.getY() - this.getJMenuBar().getBounds().getHeight()), (int)r.getWidth(), (int)r.getHeight());
		super.setBounds(r);
	}
}
