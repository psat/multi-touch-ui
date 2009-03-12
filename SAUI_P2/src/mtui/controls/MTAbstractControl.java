package mtui.controls;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import mtui.constants.DrawConstants;


import processing.core.PApplet;


/**
 * Defines <b>any</b> object that is <b>inserted</b> on the <b>processing applet.</b>
 * <p>
 * Implements IMTControl interface
 * 
 * @see mtui.controls.IMTControl
 * 
 * @author Nuno Santos
 */
public abstract class MTAbstractControl extends Component implements IMTControl {

	
	private static final long serialVersionUID = 1L;
	
	private int mZIndez;
	public MTAbstractControl(){
		this.setBounds(this.getRandomBounds());
	}
	public Rectangle getRandomBounds(){
		Random rand = new Random();
		
		int intWidth = rand.nextInt(DrawConstants.MAX_RANDOM_SIZE - DrawConstants.MIN_RANDOM_SIZE)+DrawConstants.MIN_RANDOM_POSITION;
		int intHeight = rand.nextInt(2*DrawConstants.MAX_RANDOM_SIZE_VARIATION) - DrawConstants.MAX_RANDOM_SIZE_VARIATION + intWidth;
		
		int intPosX = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
		int intPosY = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
		
		return new Rectangle(intPosX, intPosY, intWidth, intHeight);
	}
	
	@Override
	public abstract void DrawControl(PApplet app);

	@Override
	public void Move(int aDistX, int aDistY){
		int newPosX = this.getX() + aDistX; 
		int newPosY = this.getY() + aDistY;
		this.setLocation(new Point(newPosX, newPosY));
	}

	@Override
	public void Resize(int aDistX, int aDistY, int aOtherDistX, int aOtherDistY){
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

	private ArrayList<MTAbstractPointer> Pointers = new ArrayList<MTAbstractPointer>();
	
	public ArrayList<MTAbstractPointer> getPointers(){
		return this.Pointers; 
	}
	@Override
	public void setZIndex(int aZIndex) {
		this.mZIndez = aZIndex;	
	}
	@Override
	public int getZIndex() {
		return this.mZIndez;
	}
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		this.getPointers().add(pointer);
	}
	
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		this.getPointers().remove(pointer);
	}
	
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		if(!this.getPointers().contains(pointer)){
			this.getPointers().add(pointer);
		}	
	}
	

}
