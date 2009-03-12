package mtui.controls.shapes;

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
@SuppressWarnings("serial")
public class MTEllipse extends MTAbstractControl {

	public MTEllipse(){
		super();
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.ellipseMode(PApplet.CORNER);
		app.ellipse(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}
}
