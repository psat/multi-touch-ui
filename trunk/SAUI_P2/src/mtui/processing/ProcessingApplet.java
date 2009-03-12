package mtui.processing;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import mtui.constants.AppletConst;
import mtui.constants.ConfigXML;
import mtui.controls.*;
import mtui.controls.compound.MTToolbar;
import mtui.utils.byZIndex;

import org.w3c.dom.*;

import processing.core.PApplet;
import tuio.TuioClient;
import tuio.TuioCursor;
import tuio.TuioObject;


/**
 * An extended version of processing.core.PApplet.
 * 
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
	private Rectangle mParentSize;

	private static ProcessingApplet instance = null;
	
	public static ProcessingApplet getInstance(){
		if(instance == null){
			instance = new ProcessingApplet();
		}
		return instance;
	}
	
	private ProcessingApplet(){
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
	/*}catch(Exception ex){
		System.out.println(ex);
	}*/
		
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

	public void setParentSize(Rectangle aParentSize) {
		this.mParentSize = aParentSize;
		
		System.out.println(this.mParentSize);
		
	}
}
