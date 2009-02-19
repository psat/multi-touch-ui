package MTUI_WT.Controls;

import java.awt.AWTEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import processing.core.PApplet;


public class MTPointer extends MTAbstractControl{

	private static final long serialVersionUID = 1L;

	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		this.setLocation(e.getPoint());
	}
}
