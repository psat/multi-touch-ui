package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import processing.core.PApplet;

public class MTEllipse extends MTAbstractShape {

	public MTEllipse(Rectangle aBounds){
		this.setBounds(aBounds);
		
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.ellipseMode(app.CORNER);
		app.ellipse(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}
}
