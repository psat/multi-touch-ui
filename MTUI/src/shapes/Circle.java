package shapes;

import processing.core.PApplet;

public class Circle extends AbstractShape{

	private int diameter;

	public Circle(int posX, int posY, int diameter){
		super();
		this.posX = posX;
		this.posY = posY;
		this.diameter = diameter;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.ellipse(posX, posY, diameter, diameter);
		pApplet = app;
	}

	private boolean overCircle(int x, int y, int diameter) 
	{
		float disX = x - pApplet.mouseX;
		float disY = y - pApplet.mouseY;
		if(Math.sqrt(pApplet.sq(disX) + pApplet.sq(disY)) < diameter/2 ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void pressed() {
		if(over && pApplet.mousePressed) {
			pressed = true;
		} else {
			pressed = false;
		}  
	}
	
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

}
