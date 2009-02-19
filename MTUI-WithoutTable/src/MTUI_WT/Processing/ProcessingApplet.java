package MTUI_WT.Processing;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.sun.corba.se.impl.activation.ProcessMonitorThread;

import processing.core.PApplet;
import MTUI_WT.Controls.*;

public class ProcessingApplet extends PApplet implements IProcessingApplet {
	

	private static final long serialVersionUID = 1L;
	private ArrayList<IMTControl> Controls = new ArrayList<IMTControl>();
	
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


}
