package MTUI;

import java.awt.Color;

import shapes.AbstractShape;
import shapes.Rect;
import MTUI.Controls.*;
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
		
	
		
		RectangleButton toolbarButton = new RectangleButton(toolbar);
		toolbar.addControl(toolbarButton);
		
		/*
		MTToolBarButton ellipse = new MTToolBarButton();
		ellipse.setImageBackground("images/ellipse.gif");
		toolbar.addControl(ellipse);
		*/
		
	}

}
