package MTUI_WT;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import processing.core.PApplet;

public class ProcessingApplet extends PApplet {
	
	private static final long serialVersionUID = 1L;
	private Dimension AppletDimension;
	
	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}
	public ProcessingApplet(Dimension aAppletDimension){
		this.AppletDimension = aAppletDimension;
	}
	/**
	 * First draw of the Processing Applet.<p>
	 * Configuration of the UI
	 */
	public void setup(){
		size((int)this.AppletDimension.getWidth(), (int)this.AppletDimension.getHeight());
		
		background(0);
	}

	/**
	 * Method responsible for the constant draw of the UI
	 */
	public void draw(){
		stroke(255);
		
		if(mousePressed){
			line(mouseX, mouseY, pmouseX, pmouseY);
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		System.out.println(arg0.getX() +"\t" + arg0.getY());
		
		//ellipse(arg0.getX(),arg0.getY(),10,10);
		
		// TODO Auto-generated method stub
		super.mouseMoved(arg0);
	}
	
}
