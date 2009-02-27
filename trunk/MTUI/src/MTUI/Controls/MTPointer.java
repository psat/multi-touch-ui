package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import tuio.TuioCursor;

/**
 * Interface that extends MTUI.Controls.MTAbstractControl and represents the finger position on the table.
 * 
 * @see MTUI.Controls.MTAbstractControl
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public class MTPointer extends MTAbstractControl {

	private static final long serialVersionUID = 1L;
	
	private int mFingerID;
	
	public MTPointer(int aFingerID){
		this.mFingerID=aFingerID;
		this.setZIndex(10000);
	}
	
	public int getFingerID(){
		return this.mFingerID;
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
	
}
