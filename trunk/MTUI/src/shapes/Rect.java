package shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import MTUI.Constants.AppletConst;
import processing.core.PApplet;
import tuio.TuioCursor;


public class Rect extends AbstractShape{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;

	public Rect(int posX, int posY, int height, int width){
		super();
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;		
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.rect(posX, posY, height, width);
		pApplet = app;
		
		Rectangle pointerBounds = new Rectangle((int)(this.getCursorLocation().getX()*app.getWidth()), 
												(int)(this.getCursorLocation().getY()*app.getHeight()), 
												AppletConst.POINTER_SIZE, AppletConst.POINTER_SIZE);
	
		if ( this.getBounds().intersects(pointerBounds) && (pointerBounds.getX()!=0)
				&&(pointerBounds.getY()!=0)){
			Move(pointerBounds.getLocation());
		}
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		this.pressed = true;
		super.addTuioCursor(cursor);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	/*
	public boolean overRect(int x, int y, int width, int height) {
		if (this.getCursorLocation().getX() >= x && this.getCursorLocation().getX() <= x+width && 
				this.getCursorLocation().getY() >= y && this.getCursorLocation().getY() <= y+height) {
			return true;
		} else {
			return false;
		}
	}*/
	
	/*
	@Override
	public void pressed() {
		if(over && pApplet.mousePressed) {
			pressed = true;
		} else {
			pressed = false;
		}   
	}*/

	@Override
	public void Move(Point location) {
			this.setPosX((int)location.getX());
			this.setPosY((int)location.getY());
	}

	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(long arg0) {
		// TODO Auto-generated method stub
		
	}
}