package MTUI.Controls;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import tuio.TuioCursor;
import tuio.TuioObject;

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

	private float TuioX;
	private float TuioY;
	@Override
	public void DrawControl(PApplet app) {
		// TODO Auto-generated method stub
		
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
	public void addTuioCursor(TuioCursor cursor) {
		
	}

	@Override
	public void addTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setTuioLocation(float x, float y){
		this.TuioX = x;
		this.TuioY = y;
	}
	public float getTuioX(){
		return this.TuioX;
	}
	public float getTuioY(){
		return this.TuioY;
	}
	
}
