package saui_pr2_pkg2;

import java.util.Hashtable;
import processing.core.*;
import tuio.*;

public class MyProcessingSketch extends PApplet implements TuioListener{

	private Hashtable<Long,TuioCursor> cursorList;

	public static void main(String args[]){
		
		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
		
	}
	// test SVN

	public void setup(){
		size(200,200);
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
		stroke(255);
			//line(i++, 10, 2, 2);
		point((int)(posx*200),(int)(posy*200));
		
		//(int)(oldposx*200),(int)(oldposy*200));
		//oldposx=posx;
		//oldposy=posy;
	}

	float oldposx;
	float oldposy;
	 float posx;
	 float posy;
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