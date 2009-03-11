package MTUI.Controls.Compound.Component;

import java.awt.Dimension;
import java.io.File;

import MTUI.Constants.AppletConst;
import MTUI.Processing.ProcessingApplet;
import processing.core.PApplet;
import processing.core.PImage;

public class ButtonLock extends MTAbstractCompoundComponent{

	private PImage imgLockOpen;
	private PImage imgLockClosed;
	private PImage img;
	private boolean boolLocked;
	
	public ButtonLock() {
		this.setReferenceSize(new Dimension(20,20));
		imgLockOpen = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_o.jpg");
		imgLockClosed = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_c.jpg");
		img = imgLockOpen;
	}
	
	private void changeLockState(){
		if(boolLocked){
			boolLocked = false;
			img = imgLockOpen;
		}
		else{
			boolLocked = true;
			img = imgLockClosed;
		}
		
	}
	@Override
	public void DrawControl(PApplet app) {
		if(this.cursorPress){
			this.cursorPress = false;
			this.changeLockState();
		}
		app.image(img, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}

}
