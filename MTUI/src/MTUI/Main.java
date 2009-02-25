package MTUI;

import java.awt.Color;

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
		
		/*
		MTToolBarButton ellipse = new MTToolBarButton();
		ellipse.setImageBackground("images/ellipse.gif");
		toolbar.addControl(ellipse);
		*/
		
	}

}
