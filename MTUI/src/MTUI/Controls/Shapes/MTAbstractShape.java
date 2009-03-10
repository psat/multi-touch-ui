package MTUI.Controls.Shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import MTUI.Constants.DrawConstants;
import MTUI.Controls.MTAbstractControl;

public abstract class MTAbstractShape extends MTAbstractControl{

	public MTAbstractShape(){
		this.setBounds(this.getRandomBounds());
	}

	@Override
	public void Move(int aDistX, int aDistY) {
		int newPosX = this.getX() + aDistX; 
		int newPosY = this.getY() + aDistY;
		this.setLocation(new Point(newPosX, newPosY));
	
	}

	@Override
	public void Resize(int aDistX, int aDistY, int aOtherDistX, int aOtherDistY) {
				
		
		if(aOtherDistX<=0 && aOtherDistY >= 0 ){
			System.out.println("3");
			this.setLocation(new Point((int) (this.getX())+aDistX, this.getY()));
			this.setSize((int) (this.getWidth()-aDistX),(int) (this.getHeight()+aDistY));
		}
		else if(aOtherDistX>=0 && aOtherDistY >= 0){
			System.out.println("4");
			//this.setLocation(new Point((int) (this.getX()+distX), this.getY()));
			this.setSize((int) (this.getWidth()+aDistX),(int) (this.getHeight()+aDistY));
		}
		else if(aOtherDistX>=0 && aOtherDistY <= 0){
			System.out.println("2");
			this.setLocation(new Point((int) (this.getX()), (int) (this.getY()+aDistY)));
			this.setSize((int) (this.getWidth()+aDistX),(int) (this.getHeight()-aDistY));
		}
		else if(aOtherDistX<=0 && aOtherDistY <= 0){
			System.out.println("1");
			this.setLocation(new Point((int) (this.getX()+aDistX), (int)(this.getY()+aDistY)));
			this.setSize((int) (this.getWidth()-aDistX),(int) (this.getHeight()-aDistY));
		}
		
	}
	
	public Rectangle getRandomBounds(){
		Random rand = new Random();
		
		int intWidth = rand.nextInt(DrawConstants.MAX_RANDOM_SIZE - DrawConstants.MIN_RANDOM_SIZE)+DrawConstants.MIN_RANDOM_POSITION;
		int intHeight = rand.nextInt(2*DrawConstants.MAX_RANDOM_SIZE_VARIATION) - DrawConstants.MAX_RANDOM_SIZE_VARIATION + intWidth;
		
		int intPosX = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
		int intPosY = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
		
		return new Rectangle(intPosX, intPosY, intWidth, intHeight);
	}

}
