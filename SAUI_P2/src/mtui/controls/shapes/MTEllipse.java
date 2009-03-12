package mtui.controls.shapes;

import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;


import processing.core.PApplet;

/**
 * Extended class from mtui.controls.MTAbstractControl.
 * 
 * Defines an ellipse control. 
 * <p>Set definitions when drawing.
 * 
 * @see mtui.controls.MTAbstractControl
 * @author Nuno Santos
 *
 */
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
