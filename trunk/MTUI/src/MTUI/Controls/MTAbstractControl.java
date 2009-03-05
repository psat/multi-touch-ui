package MTUI.Controls;

import java.awt.*;
import java.util.ArrayList;

import processing.core.PApplet;


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
	
	@Override
	public abstract void DrawControl(PApplet app);

	@Override
	public abstract void Move(Point location);

	@Override
	public abstract void Resize(Dimension size);

	private ArrayList<Integer> Pointers = new ArrayList<Integer>();
	
	public ArrayList<Integer> getPointers(){
		return this.Pointers;
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
