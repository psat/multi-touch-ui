package saui_pr2;
import processing.core.*;


public class MyProcessingSketch extends PApplet{

	private int mHeight;
	private int mWidth;
	
	public MyProcessingSketch(double aWidth, double aHeight){
		this.mHeight = (int)aHeight;
		this.mWidth = (int)aWidth;
		
	}
	public static void main(String args[]){
	
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}
	public void setup(){
		System.out.print(this.mWidth+"\t"+this.mHeight);
		size(this.mWidth,this.mHeight);
		background(0);
		
	}
	public void draw(){
		stroke(255);
		rect(0,0,this.width,60);
		PImage a = loadImage("action.gif.jpg");
		image(a, 10, 10, 40, 40);
		if(mousePressed){
			line(mouseX, mouseY, pmouseX, pmouseY);
		}
	}
}
