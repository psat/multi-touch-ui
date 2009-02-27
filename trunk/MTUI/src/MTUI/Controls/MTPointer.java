package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import tuio.TuioCursor;
import tuio.TuioPoint;

/**
 * Interface that extends MTUI.Controls.MTAbstractControl and represents the finger position on the table.
 * 
 * @see MTUI.Controls.MTAbstractControl
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public class MTPointer extends MTAbstractControl {

	private TuioPoint CursorLocation;
	private static final long serialVersionUID = 1L;
	
	private int mFingerID;
	
	public MTPointer(int aFingerID){
		this.mFingerID=aFingerID;
		this.setZIndex(10000);
	}
	
	public int getFingerID(){
		return this.mFingerID;
	}
	
	public void setCursorLocation(float x, float y){
		this.CursorLocation = new TuioPoint(x,y);
	}
	public TuioPoint getCursorLocation(){
		if(this.CursorLocation==null) this.CursorLocation = new TuioPoint(0,0);
		return this.CursorLocation;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getCursorLocation().getX()*app.getWidth(), this.getCursorLocation().getY()*app.getHeight(), this.getWidth(), this.getHeight());

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
	public boolean equals(Object obj) {
		if(obj instanceof MTPointer) return this.mFingerID == ((MTPointer)obj).getFingerID();
		else return super.equals(obj);
	}

	
}
