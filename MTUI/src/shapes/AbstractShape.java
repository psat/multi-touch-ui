package shapes;

import java.awt.Color;

import processing.core.PApplet;
import MTUI.Controls.MTAbstractControl;

public abstract class AbstractShape extends MTAbstractControl {

	private static final long serialVersionUID = 1L;
	private Color basecolor, highlightcolor;
	private Color currentcolor;
	protected boolean over;
	protected boolean pressed;	
	protected int posX, posY;
	protected PApplet pApplet;

	public AbstractShape(){
		basecolor = highlightcolor = currentcolor = Color.WHITE;
		over = false;
		pressed = false;
	}
	
	//public abstract void pressed();
		
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
