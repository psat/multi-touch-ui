package mtui.processing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;

import mtui.constants.*;
import mtui.processing.ProcessingApplet;
import mtui.utils.HandlerEventsMenuItem;


/**
 * An extended version of javax.swing.JFrame that contains a menu bar and a pane with the processing applet.
 *<p>
 * @see javax.swing.JFrame
 * @author Nuno Santos
 *
 */
public class ProcessingFrame extends JFrame  {

private static final long serialVersionUID = 1L;
	
	protected ProcessingApplet app;
	
	public ProcessingFrame(String aTitle){
		super(aTitle);
		
		// Menubar
		HandlerEventsMenuItem ItemsEvent = new HandlerEventsMenuItem();
		JMenuBar menuBar = new JMenuBar();
		
		
		JMenu menuFile = new JMenu(AppletConst.MENU_FILE);
		menuBar.add(menuFile);
		
		
		JMenuItem menuItemReset = new JMenuItem(AppletConst.SUB_MENU_FILE_RESET);
		menuItemReset.addActionListener(ItemsEvent);
		menuFile.add(menuItemReset);
		
		JMenu menuMedia = new JMenu(AppletConst.MENU_MEDIA);
		menuBar.add(menuMedia);
		
		JMenuItem menuItemPictures = new JMenuItem(AppletConst.SUB_MENU_MEDIA_PICTURES);
		menuItemPictures.addActionListener(ItemsEvent);
		menuMedia.add(menuItemPictures);
		
		JMenuItem menuItemMovies = new JMenuItem(AppletConst.SUB_MENU_MEDIA_MOVIES);
		menuItemMovies.addActionListener(ItemsEvent);
		menuMedia.add(menuItemMovies);
		
		this.setJMenuBar(menuBar);
		
		
		this.setBounds(AppletConst.APPLET_X,AppletConst.APPLET_Y,AppletConst.APPLET_WIDTH, AppletConst.APPLET_HEIGHT);
		/*this.setMinimumSize(this.getSize());
		this.setPreferredSize(this.getSize());
		this.setMaximizedBounds(this.getBounds());
		this.setMaximumSize(this.getBounds().getSize());
		*/this.setResizable(false);
		this.setLayout(new GridLayout(0,1));
		
		
		
		//frame settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//applet
		app = ProcessingApplet.getInstance();
		app.setParentSize(new Dimension(this.getWidth(), this.getHeight() - 60));
		
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




}
