package MTUI.Controls.Shapes;

import java.awt.Rectangle;

import MTUI.Processing.ProcessingApplet;

import processing.core.PApplet;
import processing.core.PImage;

public class MTPicture extends MTAbstractShape{

	private PImage mPicture;
	public MTPicture(String aPicturePath, Rectangle aBounds){
		this.mPicture = ProcessingApplet.getInstance().loadImage(aPicturePath);
		this.setBounds(aBounds);
		
	}
	@Override
	public void DrawControl(PApplet app) {
		app.image(this.mPicture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
