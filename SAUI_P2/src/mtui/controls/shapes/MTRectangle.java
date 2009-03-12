package mtui.controls.shapes;

import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;


import processing.core.PApplet;
/**
 * Extended class from mtui.controls.MTAbstractControl.
 * 
 * Defines an rectangle control. 
 * <p>Set definitions when drawing.
 * 
 * @see mtui.controls.MTAbstractControl
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
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
