package shapes;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import MTUI.Constants.AppletConst;
import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.MTAbstractPointer;
import MTUI.Controls.MTPointer;
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
		if(aDistance!=0){
			double newPosX = this.getX() - (Math.cos(aAngle) * aDistance);
			double newPosY = this.getY() + (Math.sin(aAngle) * aDistance);
			this.setLocation(new Point((int)newPosX, (int)newPosY));
		}
	}

	@Override
	public void Resize(float aAngle, float aDistance, float aAngleBetweenCursors) {

		int distX = (int) (0 - (Math.cos(aAngle) * aDistance));
		int distY = (int) (Math.sin(aAngle) * aDistance);
		
	
		System.out.println(aAngleBetweenCursors);
		
		if(aAngleBetweenCursors > 0 && aAngleBetweenCursors <= 90 ){
			this.setLocation(new Point((int) (this.getX())+distX, this.getY()));
			this.setSize((int) (this.getWidth()-distX),(int) (this.getHeight()+distY));
		}
		else if(aAngleBetweenCursors > 90 && aAngleBetweenCursors <= 180){
			//this.setLocation(new Point((int) (this.getX()+distX), this.getY()));
			this.setSize((int) (this.getWidth()+distX),(int) (this.getHeight()+distY));
		}
		else if(aAngleBetweenCursors > 180 && aAngleBetweenCursors <= 270){
			this.setLocation(new Point((int) (this.getX()), (int) (this.getY()+distY)));
			this.setSize((int) (this.getWidth()+distX),(int) (this.getHeight()-distY));
		}
		else if(aAngleBetweenCursors > 270 && aAngleBetweenCursors <= 360){
			System.out.println(distX + " | " + distY);
			this.setLocation(new Point((int) (this.getX()+distX), (int)(this.getY()+distY)));
			this.setSize((int) (this.getWidth()-distX),(int) (this.getHeight()-distY));
		}
		
	}




}