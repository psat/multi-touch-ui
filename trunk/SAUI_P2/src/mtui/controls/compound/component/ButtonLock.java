package mtui.controls.compound.component;

import java.awt.Dimension;
import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTPiano;
import mtui.processing.ProcessingApplet;

import processing.core.PApplet;
import processing.core.PImage;

public class ButtonLock extends MTAbstractCompoundComponent{

	private PImage imgLockOpen;
	private PImage imgLockClosed;
	private PImage img;
	private boolean boolLocked;
	
	private MTPiano Piano;
	
	public ButtonLock(MTPiano aPiano) {
		this.Piano = aPiano;
		this.setReferenceSize(new Dimension(20,20));
		imgLockOpen = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_o.jpg");
		imgLockClosed = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_c.jpg");
		this.unLock();
	}
	
	private void Lock(){
		this.boolLocked = true;
		this.img = this.imgLockClosed;
		this.Piano.Lock();
	}
	private void unLock(){
		this.boolLocked = false;
		this.img = this.imgLockOpen;
		this.Piano.unLock();

	}
	
	private void changeLockState(){
		if(boolLocked){
			this.unLock();
		}
		else{
			this.Lock();
		}
		
	}
	@Override
	public void DrawControl(PApplet app) {
		if(this.cursorPress){
			this.cursorPress = false;
			this.changeLockState();
		}
		app.stroke(0);
		app.image(img, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}

}
