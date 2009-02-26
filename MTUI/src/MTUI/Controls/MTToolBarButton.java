package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import processing.core.*;
import tuio.TuioCursor;
import MTUI.Constants.*;

/**
 * This class implements buttons to be added to a Processing applet toolbar
 * @author Nuno Santos
 * @author PAulo Teixeira
 *
 */
public class MTToolBarButton extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	
	private String imgBackground;
	private boolean cursorPressed;
	private boolean mActive;
	private MTToolBar mParent;
	
	public void setImageBackground(String aImageLocation){
		this.imgBackground=aImageLocation;
	}
	public MTToolBarButton(MTToolBar aParent){
		this.mParent = aParent;
		this.setZIndex(6000);
	}
	
	@Override
	public void DrawControl(PApplet app) {

		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		if(this.mActive){
			app.fill(100);
		}
		Rectangle pointerBounds = new Rectangle((int)(this.getCursorLocation().getX()*app.getWidth()), (int)(this.getCursorLocation().getY()*app.getHeight()), AppletConst.POINTER_SIZE, AppletConst.POINTER_SIZE);
		
		// Although detect intersection
		// when pointer is on the corner we want to avoid intersection
		if(this.getBounds().intersects(pointerBounds) 
				&& (pointerBounds.getX()!=0)
				&&(pointerBounds.getY()!=0)){
			
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
					app.stroke(30);
			}
		} else {
			this.cursorPressed=false;
		}
		
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
		app.noStroke();
		if(!this.imgBackground.equals("")){
			PImage img = app.loadImage(this.imgBackground);
			app.image(img, this.getX()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getY()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getWidth()-2*AppletConst.TOOLBAR_BUTTON_MARGIN, this.getHeight()-2*AppletConst.TOOLBAR_BUTTON_MARGIN);
		
		}
	}
	
	public void setActive(boolean value){
		
		this.mActive=value;
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		this.cursorPressed = true;
		super.addTuioCursor(cursor);
	}
	
	@Override
	public void Move(Point location) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void refresh(long arg0) {
		// TODO Auto-generated method stub
		
	}
}
