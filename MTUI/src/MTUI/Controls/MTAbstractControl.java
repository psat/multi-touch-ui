package MTUI.Controls;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import tuio.TuioCursor;
import tuio.TuioObject;
import tuio.TuioPoint;

/**
 * Defines any object that is inserted on the processing applet.
 * <p>
 * Implements IMTControl interface
 * 
 * @see MTUI.Controls.IMTControl
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public abstract class MTAbstractControl extends Component implements IMTControl {


	private TuioPoint CursorLocation;
	private int mZIndez;
	
	private ArrayList<TuioCursor> Cursors = new ArrayList<TuioCursor>();
	
	@Override
	public abstract void DrawControl(PApplet app);

	@Override
	public abstract void Move(Point location);

	@Override
	public abstract void Resize(Dimension size);

	@Override
	public void addTuioCursor(TuioCursor cursor) {
		this.setCursorLocation(cursor.getX(), cursor.getY());
		this.Cursors.add(cursor);
	}

	@Override
	public void addTuioObject(TuioObject arg0) {
		
	}

	@Override
	public abstract void refresh(long arg0);

	@Override
	public void removeTuioCursor(TuioCursor cursor) {
		this.Cursors.remove(cursor);		
	}

	@Override
	public void removeTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor cursor) {
		
		if (this.Cursors.size()==1){
			System.out.println(cursor.getAngleDegrees(new TuioPoint(0, 0)) + " | " + cursor.getSpeedX() + " | " + cursor.getSpeedY());
		}
		this.setCursorLocation(cursor.getX(), cursor.getY());
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCursorLocation(float x, float y){
		this.CursorLocation = new TuioPoint(x,y);
	}
	@Override
	public TuioPoint getCursorLocation(){
		if(this.CursorLocation==null) this.CursorLocation = new TuioPoint(0,0);
		return this.CursorLocation;
	}
	@Override
	public void setZIndex(int aZIndex) {
		this.mZIndez = aZIndex;	
	}
	@Override
	public int getZIndex() {
		return this.mZIndez;
	}
	
}
