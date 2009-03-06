package shapes;

import java.awt.Dimension;
import java.awt.Point;

import MTUI.Controls.MTAbstractPointer;

import processing.core.PApplet;

public class Circle extends AbstractShape{

	private static final long serialVersionUID = 1L;
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

	/*
	@Override
	public void pressed() {
		if(over && pApplet.mousePressed) {
			pressed = true;
		} else {
			pressed = false;
		}  
	}*/
	
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	@Override
	public void Move(float aAngle, float aDistance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		// TODO Auto-generated method stub
		
	}



}
