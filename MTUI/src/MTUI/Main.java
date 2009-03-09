package MTUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import MTUI.Constants.AppletConst;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Controls.Toolbar.Buttons.*;
import MTUI.Processing.ProcessingApplet;
import MTUI.Processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProcessingFrame win = new ProcessingFrame(AppletConst.APPLICATION_NAME);
		
		
		
		//Processing
		
		
		MTToolBar toolbar = new MTToolBar();
		toolbar.setBackground(new Color(233,233,233));
		toolbar.setBounds(0, 0, ProcessingApplet.getInstance().getWidth(), 60);
		ProcessingApplet.getInstance().addControl(toolbar);
		
	
		
		RectangleButton toolbarButton = new RectangleButton();
		toolbar.addControl(toolbarButton);
		
		EllipseButton ellipseToolBarButton = new EllipseButton();
		toolbar.addControl(ellipseToolBarButton);
		
		PhotoButton photoToolbarButton = new PhotoButton();
		toolbar.addControl(photoToolbarButton);
		
		MovieButton movieToolBarButton = new MovieButton();
		toolbar.addControl(movieToolBarButton);
	
	}
	
	

}
