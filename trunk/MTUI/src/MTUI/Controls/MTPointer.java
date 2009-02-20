package MTUI.Controls;

import processing.core.PApplet;


public class MTPointer extends MTAbstractControl {

	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	
}
