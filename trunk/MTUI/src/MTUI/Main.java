package MTUI;

import java.awt.Color;

import MTUI.Controls.MTPointer;
import MTUI.Controls.MTToolBar;
import MTUI.Controls.MTToolBarButton;
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
		
		
		MTPointer pointer = new MTPointer();
		pointer.setBackground(new Color(0,205,0));
		pointer.setBounds(0, 0, 10, 10);
		win.getProcessingApplet().addControl(pointer);
		
	}

}
