package mtui.controls.compound.component;

import java.awt.Dimension;
import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTAbstractCompound;
import mtui.processing.ProcessingApplet;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Component that permits user set or not if a compound component is locked or not
 * <p> is represented by a simple lock image, open or closed, representing if compound component is lock or not.
 * 
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
public class ButtonLock extends MTAbstractCompoundComponent{

	private PImage imgLockOpen;
	private PImage imgLockClosed;
	private PImage img;
	private boolean boolLocked;
	
	private MTAbstractCompound mParent;
	
	/**
	 * Constructor of a lock button.
	 * <p>Lock button is a component from an compound control
	 * 
	 * @param aParent (MTAbstractCompound) Compound control who's component is inserted 
	 */
	public ButtonLock(MTAbstractCompound aParent) {
		this.mParent = aParent;
		this.setReferenceSize(new Dimension(20,20));

		imgLockOpen = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_o.jpg");
		imgLockClosed = ProcessingApplet.getInstance().loadImage(AppletConst.IMAGES_PATH + File.separator + "Lock_c.jpg");
		this.unLock();
	}
	/**
	 * Set properties for lock state
	 * <p>Set image as the closed lock
	 * <p>set parent state to lock
	 */
	private void Lock(){
		this.boolLocked = true;
		this.img = this.imgLockClosed;
		this.mParent.Lock();
	}
	/**
	 * Set properties for unlock state
	 * <p>Set image as the open lock
	 * <p>set parent state to unlock
	 */
	private void unLock(){
		this.boolLocked = false;
		this.img = this.imgLockOpen;
		this.mParent.unLock();

	}
	/**
	 * Set lock state depending of previous state
	 */
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
