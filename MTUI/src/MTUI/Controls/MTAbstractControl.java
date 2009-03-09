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
	public abstract void Move(int aDistX, int aDistY);

	@Override
	public abstract void Resize(int aDistX, int aDistY, int aOtherDistX, int intOtherDistY);

	private ArrayList<MTAbstractPointer> Pointers = new ArrayList<MTAbstractPointer>();
	
	public ArrayList<MTAbstractPointer> getPointers(){
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
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		this.getPointers().add(pointer);
	}
	
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		this.getPointers().remove(pointer);
	}
	
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		if(!this.getPointers().contains(pointer)){
			this.getPointers().add(pointer);
		}	
	}
	

}
