package MTUI.Controls;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;

import processing.core.*;
import MTUI.Constants.*;

/**
 * This class implements buttons to be added to a Processing applet toolbar
 * @author Nuno Santos
 * @author PAulo Teixeira
 *
 */
public abstract class MTAbstractToolBarButton extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	
	private String imgBackground;
	private boolean cursorPressed;
	private boolean cursorOver;
	private boolean mActive;
	private MTToolBar mParent;
	
	public void setImageBackground(String aImageLocation){
		this.imgBackground=aImageLocation;
	}
	public MTAbstractToolBarButton(MTToolBar aParent){
		this.mParent = aParent;
		this.setZIndex(6000);
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
				this.mParent.setInactiveAllChildButtons();
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
	
	public MTToolBar getToolBar(){
		return this.mParent;
	}
	
	public void setActive(boolean value){
		this.mActive=value;
	}
	public void changeActiveState(){
		if(this.mActive) this.mActive = false;
		else{
			this.mActive = true;
			this.CursorClicked();
		}
	}
	
	public abstract void CursorClicked();
	
	@Override
	@Deprecated
	public void Move(float aAngle, float aDistance) {
	}
	
	@Override
	@Deprecated
	public void Resize(Dimension size) {
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
