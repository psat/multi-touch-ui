package MTUI.Controls;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
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



	private static final long serialVersionUID = 1L;
	
	private int mZIndez;
	
	private ArrayList<MTPointer> Pointers = new ArrayList<MTPointer>();
	
	@Override
	public abstract void DrawControl(PApplet app);

	@Override
	public abstract void Move(Point location);

	@Override
	public abstract void Resize(Dimension size);

	
	@Override
	public void setZIndex(int aZIndex) {
		this.mZIndez = aZIndex;	
	}
	@Override
	public int getZIndex() {
		return this.mZIndez;
	}
	
	@Override
	public void addPointer(MTPointer pointer) {
		this.Pointers.add(pointer);
	}

	@Override
	public void removePointer(MTPointer pointer) {
		this.Pointers.remove(pointer);
	}
	@Override
	public ArrayList<MTPointer> getPointers() {
		return this.Pointers;
	}
	@Override
	public Rectangle getRectangleArea() {
		return this.getBounds();
	}
	
}
