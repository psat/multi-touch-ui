package mtui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import mtui.constants.AppletConst;
import mtui.constants.DrawConstants;
import mtui.controls.toolbar.MTToolbar;
import mtui.controls.toolbar.buttons.*;
import mtui.processing.ProcessingApplet;
import mtui.processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProcessingFrame win = new ProcessingFrame(AppletConst.APPLICATION_NAME);
		
		//Processing
		
		
		MTToolbar toolbar = new MTToolbar();
		toolbar.setBackground(new Color(233,233,233));
		toolbar.setBounds(0, 0, ProcessingApplet.getInstance().getWidth(), 60);
		ProcessingApplet.getInstance().addControl(toolbar);
		
	
		
		RectangleButton toolbarButton = new RectangleButton();
		toolbarButton.setReferenceBounds(5, 5, 10, 90);
		toolbar.addControl(toolbarButton);
		
		EllipseButton ellipseToolBarButton = new EllipseButton();
		ellipseToolBarButton.setReferenceBounds(20, 5, 10, 90);
		toolbar.addControl(ellipseToolBarButton);
		
		PhotoButton photoToolbarButton = new PhotoButton();
		photoToolbarButton.setReferenceBounds(35, 5, 10, 90);
		toolbar.addControl(photoToolbarButton);
		
		MovieButton movieToolBarButton = new MovieButton();
		movieToolBarButton.setReferenceBounds(50, 5, 10, 90);
		toolbar.addControl(movieToolBarButton);
		
		PianoButton pianoToolBarButton = new PianoButton();
		pianoToolBarButton.setReferenceBounds(65, 5, 10, 90);
		toolbar.addControl(pianoToolBarButton);
		
	}
	
	

}
