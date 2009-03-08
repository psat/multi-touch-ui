package MTUI;

import java.awt.Color;

import shapes.AbstractShape;
import shapes.Rect;
import MTUI.Controls.*;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Controls.Toolbar.Buttons.EllipseButton;
import MTUI.Controls.Toolbar.Buttons.PhotoButton;
import MTUI.Controls.Toolbar.Buttons.RectangleButton;
import MTUI.Processing.ProcessingApplet;
import MTUI.Processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProcessingFrame win = new ProcessingFrame("Multi-Touch");
		
		MTToolBar toolbar = new MTToolBar();
		toolbar.setBackground(new Color(233,233,233));
		toolbar.setBounds(0, 0, ProcessingApplet.getInstance().getWidth(), 60);
		ProcessingApplet.getInstance().addControl(toolbar);
		
	
		
		RectangleButton toolbarButton = new RectangleButton();
		toolbar.addControl(toolbarButton);
		
		EllipseButton ellipseToolBarButton = new EllipseButton();
		toolbar.addControl(ellipseToolBarButton);
		
		PhotoButton photoToolbarButton = new PhotoButton("C:\\Documents and Settings\\ns\\My Documents\\My Pictures");
		toolbar.addControl(photoToolbarButton);
	
	}

}
