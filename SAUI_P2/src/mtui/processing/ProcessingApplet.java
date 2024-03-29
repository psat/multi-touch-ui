package mtui.processing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

import mtui.constants.AppletConst;
import mtui.controls.*;
import mtui.controls.compound.MTToolbar;
import mtui.utils.byZIndex;

import processing.core.PApplet;
import tuio.TuioClient;
import tuio.TuioCursor;
import tuio.TuioObject;


/**
 * An extended version of processing.core.PApplet.
 * <p>
 * Represents the processing environment
 * <p>
 * Implements Singleton design pattern and mtui.processing.IProcessingApplet
 * 
 * @see processing.core.PApplet
 * @see java.applet.Applet
 * @author Nuno Santos
 *
 */
public class ProcessingApplet extends PApplet implements IProcessingApplet{

	private static final long serialVersionUID = 1L;
	private ArrayList<MTAbstractControl> Controls = new ArrayList<MTAbstractControl>();
	private ArrayList<MTAbstractPointer> Pointers = new ArrayList<MTAbstractPointer>();
	private TuioClient tuio;
	private Dimension mParentSize;

	private static ProcessingApplet instance = null;
	
	public static ProcessingApplet getInstance(){
		if(instance == null){
			instance = new ProcessingApplet();
		}
		return instance;
	}
	
	private ProcessingApplet(){
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		      public void uncaughtException(Thread t, Throwable ex) {
		    	  if(ex.toString().indexOf("OutOfMemory")!=-1){
		    		  System.out.println(AppletConst.ERROR_MEMORY);
		    	  }else{
		    		  System.out.println("Error has ocurred. Restart the application");
		    		  System.out.println("Exception was: " + ex.toString());
		      
		    	  }
		      }
		    });
		System.out.println("Welcome to the Multi-Touch User Interface..");
		this.tuio = new TuioClient(3333);

		if (this.tuio!=null) {
			this.tuio.connect();
			this.tuio.addTuioListener(this);
		} else {
			System.out.println("Wrong or not available port: Port N�3333");
		}	
		System.out.println("Listening for TUIO messages at 127.0.0.1:3333");
	}
	
	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}
	
	
	/**
	 * 
	 * @return A list of controls that are designed on the processing applet
	 */
	public ArrayList<MTAbstractControl> getControls(){
		
		return this.Controls;
	}
	/**
	 * Add control to processing applet.
	 * <p>
	 * Update list of controls which is responsible for its draw and add the cursor listener
	 * @param control
	 */
	public void addControl(MTAbstractControl control){
		this.Controls.add(control);
		if(control.getZIndex()==0) control.setZIndex(this.Controls.size()+1);
	}
	
	/**
	 * clear the canvas. Return to beginning state
	 */
	public void Reset(){
		ArrayList<MTAbstractControl> removableControls = new ArrayList<MTAbstractControl>();
		for(MTAbstractControl control : this.Controls)
			if(!(control instanceof MTToolbar))
				removableControls.add(control);
		
		for(MTAbstractControl control : removableControls)
			this.Controls.remove(control);	

	}

	@Override
	public void setup(){
		
		background(0);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void draw(){

		//mac work around
		try{
			background(0);
			noStroke();
			
			//set deep order
			//use clone
			ArrayList<MTAbstractControl> cloneControls = (ArrayList<MTAbstractControl>) this.Controls.clone();
			Collections.sort(cloneControls, new byZIndex());
	
			for(IMTControl control : cloneControls){
				control.DrawControl(this);
			}
			
			//use clone avoiding concurrent updates
			for(MTAbstractPointer pointer : (ArrayList<MTAbstractPointer>) this.Pointers.clone())
				pointer.DrawControl(this);
		}catch(Exception ex){
			
		}
		
	}


	@Override
	public void addTuioCursor(TuioCursor cursor) {
		Rectangle rPointerBounds = new Rectangle((int) (cursor.getX()*this.mParentSize.getWidth()), (int) (cursor.getY()*this.mParentSize.getHeight()), AppletConst.POINTER_SIZE,AppletConst.POINTER_SIZE);
		MTPointer pointer = new MTPointer(cursor.getFingerID(), this.Controls, rPointerBounds);
		this.Pointers.add(pointer);
		
	}


	@Override
	public void addTuioObject(TuioObject cursor) {
		Rectangle rPointerBounds = new Rectangle((int) (cursor.getX()*this.mParentSize.getWidth()), (int) (cursor.getY()*this.mParentSize.getHeight()), AppletConst.POINTER_SIZE,AppletConst.POINTER_SIZE);
		MTPointer pointer = new MTPointer(cursor.getFiducialID(), this.Controls, rPointerBounds);
		this.Pointers.add(pointer);
	}

	@Override
	public void removeTuioCursor(TuioCursor cursor) {
		
		for(MTAbstractPointer pointer : this.Pointers){
			if(pointer.getFingerID()==cursor.getFingerID()){
				pointer.clear();
				this.Pointers.remove(pointer);
				break;
			}
		}
	}


	@Override
	public void removeTuioObject(TuioObject cursor) {
		for(MTAbstractPointer pointer : this.Pointers){
			if(pointer.getFingerID()==cursor.getFiducialID()){
				pointer.clear();
				this.Pointers.remove(pointer);
				break;
			}
		}
	}


	@Override
	public void updateTuioCursor(TuioCursor cursor) {
		
		for(MTAbstractPointer pointer : this.Pointers){
			if(pointer.getFingerID() == cursor.getFingerID()){
				pointer.setLocation(new Point((int) (cursor.getX()*this.mParentSize.getWidth()), (int) (cursor.getY()*this.mParentSize.getHeight())));
				pointer.run();
				break;
			} 
		}
		
	}


	@Override
	public void updateTuioObject(TuioObject cursor) {
		for(MTAbstractPointer pointer : this.Pointers){
			if(pointer.getFingerID() == cursor.getFiducialID()){
				pointer.setLocation(new Point((int) (cursor.getX()*this.mParentSize.getWidth()), (int) (cursor.getY()*this.mParentSize.getHeight())));
				pointer.run();
				break;
			} 
		}
	}
	@Override
	public void refresh(long arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setParentSize(Dimension aParentSize) {
		this.mParentSize = aParentSize;
		
	}
}
