package shapes;

import java.awt.Color;
import processing.core.*;

public abstract class AbstractShape extends PApplet{
	
	private Color basecolor, highlightcolor;
	private Color currentcolor;
	private boolean over;
	private boolean pressed;	
	protected int posX, posY;

	public AbstractShape(){
		basecolor = highlightcolor = currentcolor = Color.WHITE;
		over = false;
		pressed = false;
	}
	
	public void pressed() {
		if(over && mousePressed) {
			pressed = true;
		} else {
			pressed = false;
		}    
	}
	
	public Color getBasecolor() {
		return basecolor;
	}

	public void setBasecolor(Color basecolor) {
		this.basecolor = basecolor;
	}

	public Color getHighlightcolor() {
		return highlightcolor;
	}

	public void setHighlightcolor(Color highlightcolor) {
		this.highlightcolor = highlightcolor;
	}

	public Color getCurrentcolor() {
		return currentcolor;
	}

	public void setCurrentcolor(Color currentcolor) {
		this.currentcolor = currentcolor;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
