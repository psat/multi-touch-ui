package saui_pr2;
import java.util.Hashtable;

import processing.core.*;
import tuio.TuioClient;
import tuio.TuioCursor;
import tuio.TuioListener;
import tuio.TuioObject;


public class MyProcessingSketch extends PApplet implements TuioListener{

	private int mHeight;
	private int mWidth; 
	
	float oldposx;
	float oldposy;
	float posx;
	float posy;
	 
	private Hashtable<Long,TuioCursor> cursorList;
	
	public MyProcessingSketch(double aWidth, double aHeight){
		this.mHeight = (int)aHeight;
		this.mWidth = (int)aWidth;
		
	}
	
	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});	
	}
	
	public void setup(){
		size(this.mWidth,this.mHeight);
		background(0);
		
		cursorList = new Hashtable<Long,TuioCursor>();
		TuioClient client = new TuioClient(3333);

		if (client!=null) {
			client.addTuioListener(this);
			client.connect();
		} else {
			System.out.println("Wrong or not available port: Port Nº3333");
			System.exit(0);
		}
		
	}
	
	public void draw(){
		background(0);
		
		rect(0,0,this.width,60);
		PImage a = loadImage("action.gif.jpg");
		image(a, 10, 10, 40, 40);
		stroke(255);
		
		point((int)(posx*mWidth),(int)(posy*mHeight));		
		//(int)(oldposx*200),(int)(oldposy*200));
		//oldposx=posx;
		//oldposy=posy;
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		//verificar isto.....
		if (!cursorList.containsKey(cursor.getSessionID())) {
			cursorList.put(cursor.getSessionID(), cursor);
			
		}
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
	public void updateTuioCursor(TuioCursor cursor) {
		// TODO Auto-generated method stub
		posx=cursor.getX();
		posy = cursor.getY();
	
		System.out.println(cursor.getX()+"   "+cursor.getY());

	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub

	}
	
}
