package MTUI;

import java.awt.Color;

import shapes.AbstractShape;
import shapes.Rectangle;
import shapes.Square;

import MTUI.Controls.*;
import MTUI.Processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProcessingFrame win = new ProcessingFrame("Multi-Touch");
		
		MTToolBar toolbar = new MTToolBar();
		toolbar.setBackground(new Color(233,233,233));
		toolbar.setBounds(0, 0, win.getProcessingApplet().getWidth(), 60);
		win.getProcessingApplet().addControl(toolbar);
		
		
		MTToolBarButton toolbarButton = new MTToolBarButton();
		toolbarButton.setImageBackground("action.gif.jpg");
		toolbar.addControl(toolbarButton);
		
		AbstractShape rectangle = new Rectangle(140, 140, 50, 70);
		win.getProcessingApplet().addControl(rectangle);
		
		/*
		MTToolBarButton ellipse = new MTToolBarButton();
		ellipse.setImageBackground("images/ellipse.gif");
		toolbar.addControl(ellipse);
		*/
		
	}

}
