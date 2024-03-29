package mtui.controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mtui.constants.DrawConstants;
import mtui.controls.compound.MTToolbar;
import mtui.controls.compound.component.MTAbstractCompoundComponent;
import mtui.processing.IProcessingControl;
import mtui.utils.byInverseZIndex;
import mtui.utils.byZIndex;


import processing.core.PApplet;
import tuio.TuioPoint;

/**
 * An extended class from mtui.controls.MTAbstractControl
 *  and represents the finger position on the table.
 * <p>
 * Once that this pointer are responsible for the all actions at the table, 
 * require different handler 
 * 
 * @see mtui.controls.MTAbstractControl
 * @author Nuno Santos
 *
 */
public abstract class MTAbstractPointer extends Component implements Runnable, IProcessingControl {


	private TuioPoint mCursorLocation = new TuioPoint(0,0);
	private  boolean mCursorLocationIsSet;
	
	private static final long serialVersionUID = 1L;
	private ArrayList<MTAbstractControl> mAppControls;
	private MTAbstractControl mCurrentControl;
	private MTAbstractCompoundComponent mCurrentCompoundControl;
	
	private int mFingerID;
	
	@SuppressWarnings("unchecked")
	public MTAbstractPointer(int aFingerID, ArrayList<MTAbstractControl> aAppControls, Rectangle aBounds){
		this.mCursorLocationIsSet=false;
		this.mAppControls = aAppControls;
		this.mFingerID=aFingerID;
		this.setBounds(aBounds);
		
		ArrayList<MTAbstractControl> selectFirstObject = (ArrayList<MTAbstractControl>) this.mAppControls.clone();
		Collections.sort(selectFirstObject, new byInverseZIndex());
		
		//Event: CursorAdd
		for(MTAbstractControl control : selectFirstObject){
			if(this.IsOverControl(control)){
				this.mCurrentControl = control;
				control.CursorAdd(this);
				
				BringObjectToFront(control);
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void BringObjectToFront(MTAbstractControl control) {
		
		ArrayList<MTAbstractControl> appControlsClone = (ArrayList<MTAbstractControl>) this.mAppControls.clone();
		Collections.sort(appControlsClone, new byZIndex());
		int controlIndex = appControlsClone.indexOf(control);
		List<MTAbstractControl> listControls2Change = appControlsClone.subList(controlIndex, appControlsClone.size() -1 );
		
		for (MTAbstractControl control2change : listControls2Change){
			if(!(control2change instanceof MTToolbar)){
				control2change.setZIndex(control2change.getZIndex()-1);
				control.setZIndex(control.getZIndex()+1);
			}
		}
		
		
	}

	public int getFingerID(){
		return this.mFingerID;
	}
	public void setCurrentControl(MTAbstractControl control){
		this.mCurrentControl = control;
	}
	
	public void setCurrentCompoundControl(MTAbstractCompoundComponent component){
		if(this.mCurrentCompoundControl!=null) 
			if(this.mCurrentCompoundControl!=component){
				this.mCurrentCompoundControl.CursorOut(this);
			}
		
		this.mCurrentCompoundControl = component;
	}
	public MTAbstractCompoundComponent getCurrentCompoundControl(){
		return this.mCurrentCompoundControl;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipseMode(PApplet.CORNER);
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MTAbstractPointer) return this.mFingerID == ((MTAbstractPointer)obj).getFingerID();
		else return super.equals(obj);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		int intDistX=0;
		int intDistY=0;
		//set values for movement
		if(this.mCursorLocationIsSet){		
			intDistX=(int)(this.getX() - this.mCursorLocation.getX()) ;
			intDistY=(int)(this.getY() - this.mCursorLocation.getY());
		}
	

		// choose type of action (MOVE-RESIZE-ROTATE)
		if(this.mCurrentControl!=null){
			MTAbstractPointer otherPointer = this;
			
			// MOVE :
			if(this.mCurrentControl.getPointers().size()==1){
				mCurrentControl.Move(intDistX, intDistY);
			}
			else if(this.mCurrentControl.getPointers().size()==2){
				for(MTAbstractPointer pointer : this.mCurrentControl.getPointers()){
					if (!pointer.equals(this)){
						otherPointer = pointer;
						break;
					}
				}
				
				
				//RESIZE : Two fingers.. need to give the position to the other pointer
				int intOtherDistX = this.getX() - otherPointer.getX();
				int intOtherDistY = this.getY() - otherPointer.getY();
				
				mCurrentControl.Resize(intDistX, intDistY, intOtherDistX, intOtherDistY);
			}
		}
		
		// Justify usage of clone because main collection is been used in processing redraw
		ArrayList<MTAbstractControl> cloneControls = (ArrayList<MTAbstractControl>) this.mAppControls.clone();
		Collections.sort(cloneControls, new byInverseZIndex());
		for(MTAbstractControl control : cloneControls){
			
			//Event: CursorOut
			if(this.IsOverControl(control)){
				if(this.mCurrentControl!=null){
					if(!control.equals(this.mCurrentControl)){
						this.mCurrentControl.CursorOut(this);
					} 
				}
				
				//Event: CursorOver
				this.mCurrentControl = control;
				control.CursorOver(this);
				break;
			} else {
				
				//Event: CursorOut
				if(this.mCurrentControl!=null){
					if(control.equals(this.mCurrentControl)){
						this.mCurrentControl.CursorOut(this);
						this.mCurrentControl = null;
					}
				}
			}
		}
	
		this.mCursorLocation = new TuioPoint(this.getX(), this.getY());
		this.mCursorLocationIsSet=true;
	}
	public boolean IsOverControl(MTAbstractControl control){
		Rectangle pointerBounds = new Rectangle((int)this.getBounds().getCenterX(), (int)this.getBounds().getCenterY(), 1, 1);
		return control.getBounds().intersects(pointerBounds);
		
	}
	public void clear(){
		if(this.mCurrentControl!=null) this.mCurrentControl.CursorOut(this);
		this.mCurrentControl=null;
	}

	@Override
	public int getZIndex() {
		return DrawConstants.MAX_ZINDEX;
	}

	@Override
	@Deprecated
	public void setZIndex(int index) {
	}
	

	
}
