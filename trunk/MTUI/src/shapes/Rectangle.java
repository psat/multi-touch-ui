package shapes;

import processing.core.PApplet;
import tuio.TuioCursor;


public class Rectangle extends AbstractShape{
	
	private int width, height;

	public Rectangle(int posX, int posY, int height, int width){
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
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		//this.cursorPressed = true;
		super.addTuioCursor(cursor);
	}
	
	public boolean overRect(int x, int y, int width, int height) {
		if (pApplet.mouseX >= x && pApplet.mouseX <= x+width && 
				pApplet.mouseY >= y && pApplet.mouseY <= y+height) {
			return true;
		} else {
			return false;
		}
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

	@Override
	public void pressed() {
		if(over && pApplet.mousePressed) {
			pressed = true;
		} else {
			pressed = false;
		}   
	}
}