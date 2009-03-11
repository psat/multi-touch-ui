package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import MTUI.Controls.MTAbstractControl;

import processing.core.PApplet;

public class MTEllipse extends MTAbstractControl {

	public MTEllipse(){
		super();
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.ellipseMode(app.CORNER);
		app.ellipse(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}
}
