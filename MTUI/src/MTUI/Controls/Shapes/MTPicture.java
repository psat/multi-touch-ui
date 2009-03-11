package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import MTUI.Controls.MTAbstractControl;
import MTUI.Processing.ProcessingApplet;

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
