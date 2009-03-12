package mtui.controls.toolbar.buttons;

import mtui.constants.*;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.component.MTAbstractCompoundComponent;

import processing.core.*;

/**
 * An extended class from mtui.controls.compound.component.MTAbstractCompoundComponent
 * <p>This class change the common definition of components to buttons in order to be added to a Processing applet toolbar.
 * <p>Toolbar buttons have specific characteristics such as static in space, i.e. doesn't move or resize.
 * Also has a background image and specific handling for cursors events.
 * @author Nuno Santos
 *
 */
public abstract class MTAbstractToolbarButton extends MTAbstractCompoundComponent{

	private static final long serialVersionUID = 1L;
	
	private String imgBackground;
	private boolean cursorPressed;
	private boolean cursorOver;
	private boolean mActive;
	
	/**
	 * set the image path
	 * @param aImageLocation (String) Image path
	 */
	public void setImageBackground(String aImageLocation){
		this.imgBackground=aImageLocation;
	}
	
	public MTAbstractToolbarButton(){
		this.setZIndex(DrawConstants.BUTTONS_ZINDEX);
	}
	
	@Override
	public void DrawControl(PApplet app) {

		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		if(this.mActive)
			app.fill(100);
		
		if(this.cursorPressed){
			
			if(this.mActive) this.mActive = false;
			else{
				//disable other buttons
				//inactive all parent buttons
				this.mActive =true;
			}
		
			this.cursorPressed=false;
		}else {
			if(this.cursorOver)
				app.stroke(30);			
		}
	
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
		app.noStroke();
		if(!this.imgBackground.equals("")){
			PImage img = app.loadImage(this.imgBackground);
			app.image(img, this.getX()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getY()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getWidth()-2*AppletConst.TOOLBAR_BUTTON_MARGIN, this.getHeight()-2*AppletConst.TOOLBAR_BUTTON_MARGIN);
		
		}
	}
	
	/**
	 * Set active state to true. This influencies the design of the button.
	 * @param value
	 */
	public void setActive(boolean value){
		this.mActive=value;
	}
	/**
	 * Change the active state without depending on previous state
	 */
	public void changeActiveState(){
		if(this.mActive) this.mActive = false;
		else{
			this.mActive = true;
			this.CursorClicked();
		}
	}
	
	/**
	 * When cursor is added above one toolbar button this method is called
	 */
	public abstract void CursorClicked();
	
	@Override
	@Deprecated
	public void Move(int distX, int distY) {
	}
	
	@Override
	@Deprecated
	public void Resize(int distX, int distY, int otherDistX, int intOtherDistY) {
	}
	
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		super.CursorAdd(pointer);
		this.changeActiveState();
		this.cursorOver = true;
	}
	
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		super.CursorOut(pointer);
		this.cursorOver = false;
		this.setActive(false);
	}
	
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		super.CursorOver(pointer);
		this.cursorOver=true;
		this.setActive(false);
		
	}
}
