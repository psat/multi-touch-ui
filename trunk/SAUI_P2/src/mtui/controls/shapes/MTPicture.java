package mtui.controls.shapes;

import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;
import mtui.processing.ProcessingApplet;


import processing.core.PApplet;
import processing.core.PImage;

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
