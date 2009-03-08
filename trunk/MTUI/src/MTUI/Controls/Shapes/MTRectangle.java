package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import processing.core.PApplet;

public class MTRectangle extends MTAbstractShape{

	public MTRectangle(Rectangle aBounds){
		this.setBounds(aBounds);
		
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.rect(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}

}
