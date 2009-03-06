package MTUI.Processing;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import MTUI.Constants.*;
import MTUI.Processing.ProcessingApplet;

/**
 * An extended version of javax.swing.JFrame that contains a menu bar and a pane with the processing applet.
 *<p>
 * @see javax.swing.JFrame
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public class ProcessingFrame extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;
	
	protected ProcessingApplet app;
	
	public ProcessingFrame(String aTitle){
		super(aTitle);
		
		this.setBounds(AppletConst.APPLET_X,AppletConst.APPLET_Y,AppletConst.APPLET_WIDTH, AppletConst.APPLET_HEIGHT);
		this.setLayout(new GridLayout(0,1));
		
		
		// Menubar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemReset = new JMenuItem("Reset");
		menuItemReset.addActionListener(this);
		menuFile.add(menuItemReset);
		
		//frame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//applet
		app = ProcessingApplet.getInstance();
		app.setParentSize(this.getBounds());
		
		app.init();
		app.start();
		
		JPanel pane = new JPanel(new GridLayout(0,1));
		pane.add(app);
				
		this.getContentPane().add(pane);
		this.setVisible(true);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JMenuItem)e.getSource()).getText().equals("Reset")){
			ProcessingApplet.getInstance().Reset();
		}
		
	}


}
