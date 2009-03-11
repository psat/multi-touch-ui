package MTUI.Controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import MTUI.Constants.DrawConstants;
import MTUI.Controls.Compound.Component.MTAbstractCompoundComponent;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Processing.IProcessingControl;
import MTUI.Utils.byInverseZIndex;
import MTUI.Utils.byZIndex;

import processing.core.PApplet;
import tuio.TuioPoint;

/**
 * Interface that extends MTUI.Controls.MTAbstractControl and represents the finger position on the table.
 * 
 * @see MTUI.Controls.MTAbstractControl
 * @author Nuno Santos
 * @author Paulo Teixeira
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
	
	public MTAbstractPointer(int aFingerID, ArrayList<MTAbstractControl> aAppControls, Rectangle aBounds){
		this.mCursorLocationIsSet=false;
		this.mAppControls = aAppControls;
		this.mFingerID=aFingerID;
		this.setBounds(aBounds);
		
		ArrayList<MTAbstractControl> selectFirstObject = (ArrayList<MTAbstractControl>) this.mAppControls.clone();
		Collections.sort(selectFirstObject, new byInverseZIndex());
		
		//Event: CursorAdd
		for(MTAbstractControl control : selectFirstObject){
			if(control.getBounds().intersects(this.getBounds())){
				this.mCurrentControl = control;
				control.CursorAdd(this);
				
				BringObjectToFront(control);
				break;
			}
		}
	}
	
	private void BringObjectToFront(MTAbstractControl control) {
		
		int controlIndex = this.mAppControls.indexOf(control);
		List<MTAbstractControl> listControls2Change = this.mAppControls.subList(controlIndex, this.mAppControls.size() -1 );
		
		for (MTAbstractControl control2change : listControls2Change){
			if(!(control2change instanceof MTToolBar)){
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
		if(this.mCurrentCompoundControl!=null) this.mCurrentCompoundControl.CursorOut(this);
		this.mCurrentCompoundControl = component;
	}
	public MTAbstractCompoundComponent getCurrentCompoundControl(){
		return this.mCurrentCompoundControl;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MTAbstractPointer) return this.mFingerID == ((MTAbstractPointer)obj).getFingerID();
		else return super.equals(obj);
	}
	
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
			if(control.getBounds().intersects(this.getBounds())){
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
