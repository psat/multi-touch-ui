package MTUI.Controls;

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
	}
	public int getFingerID(){
		return this.mFingerID;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getTuioX()*app.getWidth(), this.getTuioY()*app.getHeight(), this.getWidth(), this.getHeight());

	}
	
	@Override
	public void updateTuioCursor(TuioCursor cursor) {
		this.setTuioLocation(cursor.getX(), cursor.getY());
	}
	
}
