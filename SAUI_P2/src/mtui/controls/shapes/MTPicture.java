package mtui.controls.shapes;

import mtui.controls.MTAbstractControl;
import mtui.processing.ProcessingApplet;


import processing.core.PApplet;
import processing.core.PImage;

/**
 * Extended class from mtui.controls.MTAbstractControl.
 * 
 * Defines an image control. 
 * <p>Set definitions when drawing.
 * 
 * @see mtui.controls.MTAbstractControl
 * 
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
public class MTPicture extends MTAbstractControl{

	private PImage mPicture;
	public MTPicture(String aPicturePath){
		super();
		this.mPicture = ProcessingApplet.getInstance().loadImage(aPicturePath);
		
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.image(this.mPicture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
