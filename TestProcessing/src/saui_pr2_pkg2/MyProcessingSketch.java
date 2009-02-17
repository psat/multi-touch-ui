package saui_pr2_pkg2;

import java.util.Hashtable;
import processing.core.*;
import tuio.*;

public class MyProcessingSketch extends PApplet implements TuioListener{

	private Hashtable<Long,TuioCursor> cursorList;

	public static void main(String args[]){

		PApplet.main(new String[] { "--present", "MyProcessingSketch"});
	}

	public void setup(){
		size(200,200);
		background(0);

		cursorList = new Hashtable<Long,TuioCursor>();
		TuioClient client = null;

		switch (args.length) {
		case 1:
			try { client = new TuioClient( Integer.parseInt(args[1])); }
			catch (Exception e) {}
			break;
		case 0:
			client = new TuioClient();
			break;
		}

		if (client!=null) {
			client.addTuioListener(this);
			client.connect();
		} else {
			System.out.println("usage: java TuioDemo [port]");
			System.exit(0);
		}	
	}

	public void draw(){
		stroke(255);
		if(mousePressed){
			line(mouseX, mouseY, pmouseX, pmouseY);
		}
	}

	@Override
	public void addTuioCursor(TuioCursor cursor) {
		//verificar isto.....
		if (!cursorList.containsKey(cursor.getSessionID())) {
			cursorList.put(cursor.getSessionID(), cursor);
			System.out.println(cursor.getX()+"   "+cursor.getY());
			repaint();
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
	public void updateTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTuioObject(TuioObject arg0) {
		// TODO Auto-generated method stub

	}
}