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
