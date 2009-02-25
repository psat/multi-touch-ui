package MTUI.Processing;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import tuio.TuioClient;
import tuio.TuioCursor;
import tuio.TuioObject;
import MTUI.Constants.AppletConst;
import MTUI.Controls.*;

/**
 * An extended version of processing.core.PApplet.
 * 
 * @see processing.core.PApplet
 * @see java.applet.Applet
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public class ProcessingApplet extends PApplet implements IProcessingApplet{

	private static final long serialVersionUID = 1L;
	private ArrayList<IMTControl> Controls = new ArrayList<IMTControl>();
	private TuioClient tuio;

	public ProcessingApplet(){
		this.tuio = new TuioClient(3333);

		if (this.tuio!=null) {
			this.tuio.connect();
			this.tuio.addTuioListener(this);
		} else {
			System.out.println("Wrong or not available port: Port Nº3333");
			System.exit(0);
		}
		
	}
	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}
	
	/**
	 * 
	 * @return A list of controls that are designed on the processing applet
	 */
	public ArrayList<IMTControl> getControls(){
		
		return this.Controls;
	}
	/**
	 * Add control to processing applet.
	 * <p>
	 * Update list of controls which is responsible for its draw and add the cursor listener
	 * @param control
	 */
	public void addControl(IMTControl control){
		this.tuio.addTuioListener(control);
		this.Controls.add(control);
	}

	@Override
	public void setup(){
		
		background(0);		
	}

	@Override
	public void draw(){
		
		try{
			background(0);
			noStroke();
			
			for(IMTControl control : this.Controls){
				if(control instanceof MTPointer) 
					control.DrawControl(this);
				
				else if(control instanceof MTToolBar)
					control.DrawControl(this);
				
				else control.DrawControl(this);
			}
		}catch(Exception ex){
			System.out.println("Ocorreu uma excepção do tipo:" + ex);
		}
		
	}


	@Override
	public void addTuioCursor(TuioCursor cursor) {
		MTPointer pointer = new MTPointer(cursor.getFingerID());
		pointer.setBackground(new Color(0,205,0));
		//pointer.setTuioLocation(cursor.getX(), cursor.getY());
		pointer.setSize(AppletConst.POINTER_SIZE,AppletConst.POINTER_SIZE);
		this.addControl(pointer);
		
		
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
	public void removeTuioCursor(TuioCursor cursor) {
	
		for(IMTControl control : this.Controls){
			if(control instanceof MTPointer)
				if(((MTPointer)control).getFingerID() == cursor.getFingerID()){
					this.Controls.remove(control);
					break;
				}
		}
	}


	@Override
	public void removeTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateTuioCursor(TuioCursor cursor) {}


	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub
		
	}

}
