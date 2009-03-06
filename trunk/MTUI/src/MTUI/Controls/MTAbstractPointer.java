package MTUI.Controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import MTUI.Constants.DrawConstants;
import MTUI.Processing.IProcessingControl;
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
	private float mAngle;
	private float mDistance;
	private static final long serialVersionUID = 1L;
	private ArrayList<MTAbstractControl> mAppControls;
	private MTAbstractControl mCurrentControl;
	
	private int mFingerID;
	
	public MTAbstractPointer(int aFingerID, ArrayList<MTAbstractControl> aAppControls, Rectangle aBounds){
		this.mCursorLocationIsSet=false;
		this.mAppControls = aAppControls;
		this.mFingerID=aFingerID;
		this.setBounds(aBounds);
		
		Collections.sort(this.mAppControls, new byZIndex());
		
		for(MTAbstractControl control : this.mAppControls){
			if(control.getBounds().intersects(this.getBounds())){
				this.mCurrentControl = control;
				control.CursorAdd(this);
				break;
			}
		}
	}
	
	public int getFingerID(){
		return this.mFingerID;
	}
	public void setCurrentControl(MTAbstractControl control){
		this.mCurrentControl = control;
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
		TuioPoint tpActual = new TuioPoint(this.getX(), this.getY());
		if(this.mCursorLocationIsSet){		
			this.mAngle=this.mCursorLocation.getAngleDegrees(tpActual);
			this.mDistance=this.mCursorLocation.getDistance(tpActual);
		}
		if(this.mCurrentControl!=null){
			if(this.mCurrentControl.getPointers().size()==2){
				System.out.println(this.mDistance);
				mCurrentControl.Move(this.mAngle, this.mDistance);
			}
		}
		
		Collections.sort(this.mAppControls, new byZIndex());
		for(MTAbstractControl control : this.mAppControls){
			if(control.getBounds().intersects(this.getBounds())){
				if(this.mCurrentControl!=null){
					if(!control.equals(this.mCurrentControl)){
						this.mCurrentControl.CursorOut(this);
					} 
				}
				this.mCurrentControl = control;
				control.CursorOver(this);
				break;
			} else {
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
