package mtui;

import java.awt.Color;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTToolbar;
import mtui.controls.toolbar.buttons.*;
import mtui.processing.ProcessingApplet;
import mtui.processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ProcessingFrame(AppletConst.APPLICATION_NAME);
		
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
			
		PianoButton pianoToolBarButton = new PianoButton();
		pianoToolBarButton.setReferenceBounds(50, 5, 10, 90);
		toolbar.addControl(pianoToolBarButton);
		
	}
	
	

}
