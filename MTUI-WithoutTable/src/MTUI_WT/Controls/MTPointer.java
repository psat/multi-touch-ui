package MTUI_WT.Controls;

import java.awt.event.MouseEvent;

import processing.core.PApplet;


public class MTPointer extends MTAbstractControl{

	private static final long serialVersionUID = 1L;

	@Override
	public void DrawControl(PApplet app) {
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.ellipse(this.getX(), this.getY(), this.getWidth(), this.getHeight());

	}
	@Override
	protected void processMouseMotionEvent(MouseEvent e) {
		this.setLocation(e.getPoint());
		System.out.println(e.getPoint());
		// TODO Auto-generated method stub
		super.processMouseMotionEvent(e);
	}
	
}
