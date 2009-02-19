package MTUI_WT.Processing;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import MTUI_WT.Controls.*;

public class ProcessingApplet extends PApplet implements IProcessingApplet {
	

	private static final long serialVersionUID = 1L;
	private ArrayList<IMTControl> Controls = new ArrayList<IMTControl>();
	
	private Rectangle rMouseMoved=null;
	
	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}
	public ArrayList<IMTControl> getControls(){
		
		return this.Controls;
	}

	@Override
	public void setup(){
		
		background(0);
	}

	@Override
	public void draw(){
		
		background(0);
		noStroke();
		
		
		if(mousePressed){
			line(mouseX, mouseY, pmouseX, pmouseY);
			
		}

		for(IMTControl control : this.Controls){
			if(control instanceof MTPointer) 
				control.DrawControl(this);
			
			else if(control instanceof MTToolBar)
				control.DrawControl(this);
			
			else control.DrawControl(this);
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		for(IMTControl control : this.Controls)
			if(control instanceof MTPointer)
				((MTPointer)control).setLocation(arg0.getPoint());
		
			
			
		// TODO Auto-generated method stub
		super.mouseMoved(arg0);
	}
}
