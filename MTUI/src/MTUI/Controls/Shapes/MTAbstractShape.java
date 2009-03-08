package MTUI.Controls.Shapes;

import java.awt.Point;

import MTUI.Controls.MTAbstractControl;

public abstract class MTAbstractShape extends MTAbstractControl{


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
