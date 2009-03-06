package shapes;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import MTUI.Constants.AppletConst;
import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.MTAbstractPointer;
import processing.core.PApplet;
import tuio.TuioCursor;


public class Rect extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	
	public Rect(Rectangle aBounds){
		super();
		this.setBounds(aBounds);
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.fill(50, 60, 200);
		app.rect(this.getX(),this.getY(), this.getWidth(),this.getHeight());
	}
	
	@Override
	public void Move(float aAngle, float aDistance) {
		double newPosX = this.getX() - (Math.cos(aAngle) * aDistance);
		double newPosY = this.getY() + (Math.sin(aAngle) * aDistance);
		
		this.setLocation(new Point((int)newPosX, (int)newPosY));
		
	}

	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}




}