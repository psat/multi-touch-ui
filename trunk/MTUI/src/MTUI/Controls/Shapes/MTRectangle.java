package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import MTUI.Controls.MTAbstractControl;

import processing.core.PApplet;

public class MTRectangle extends MTAbstractControl{

	public MTRectangle(){
		super();
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.rect(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}

}
