package MTUI_WT;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MTUI_WT.Controls.*;
import MTUI_WT.Processing.ProcessingFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProcessingFrame win = new ProcessingFrame("Multi-Touch");
		
		MTToolBar toolbar = new MTToolBar();
		toolbar.setBackground(new Color(233,233,233));
		toolbar.setBounds(0, 0, win.getProcessingApplet().getWidth(), 60);
		win.getProcessingApplet().getControls().add(toolbar);
		
		
		MTToolBarButton toolbarButton = new MTToolBarButton();
		toolbarButton.setBackground(new Color(180,180,180));
		toolbar.getItems().add(toolbarButton);
		
		
		MTPointer pointer = new MTPointer();
		pointer.setBackground(new Color(0,205,0));
		pointer.setBounds(0, 0, 10, 10);
		win.getProcessingApplet().addMouseMotionListener(pointer);
		win.getProcessingApplet().getControls().add(pointer);
		
		
	}
}
