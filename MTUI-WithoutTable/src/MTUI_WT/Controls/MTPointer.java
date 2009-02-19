package MTUI_WT.Controls;

import java.awt.Event;

import processing.core.PApplet;


public class MTPointer extends MTAbstractControl{

	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean mouseMove(Event evt, int x, int y) {
		
		this.setLocation(x,y);
		// TODO Auto-generated method stub
		return super.mouseMove(evt, x, y);
	}
}
