package mtui.controls.compound.component;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.MTAbstractCompound;

/**
 * Abstract class extended from mtui.controls.MTAbstractControl representing controls that are referenced as being part of an compound control. 
 * <p>This kind of controls are called components and implements <b>mtui.controls.compound.component.IMTCompoundComponent</b>.
 * 
 * <p> Components differences from control in setting position. Component controls use a reference position as an percentage of the parent size.
 *  
 * @see mtui.controls.MTAbstractControl
 * @see mtui.controls.compound.component.IMTCompoundComponent
 * 
 * @author Nuno Santos
 */
public abstract class MTAbstractCompoundComponent extends MTAbstractControl implements IMTCompoundComponent{

	private static final long serialVersionUID = 1L;
	private Dimension refSize;
	private Point refLocation;
	protected boolean cursorOver;
	protected boolean cursorPress;
	
	@Override
	public Point getReferenceLocation(){
		
		return this.refLocation;
	}
	@Override
	public void setReferenceLocation(Point location){
		
		this.refLocation =location;
	}
	@Override
	public Dimension getReferenceSize(){
		return this.refSize;
	}
	@Override
	public void setReferenceSize(Dimension size){
		this.refSize=size;
	}
	@Override
	public void setReferenceBounds(int x, int y, int width, int height){
		this.setReferenceLocation(new Point(x,y));
		this.setReferenceSize(new Dimension(width, height));
	}
	@Override
	public void UpdateSizeAndLocation(Rectangle aParentBounds){
		int newX = (int) (aParentBounds.getX() + (this.getReferenceLocation().getX()*aParentBounds.getWidth())/100);
		int newY = (int) (aParentBounds.getY() + (this.getReferenceLocation().getY()*aParentBounds.getHeight())/100);
		this.setLocation(newX, newY);
		
		int newWidth = (int) (aParentBounds.getWidth()*this.getReferenceSize().getWidth()/100);
		int newHeight = (int) (aParentBounds.getHeight()*this.getReferenceSize().getHeight()/100);
	
		this.setSize(new Dimension(newWidth, newHeight));
	}
	
	
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		this.cursorOver=true;
		this.cursorPress=true;
		super.CursorAdd(pointer);
	}
	
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		this.cursorOver=true;
		this.cursorPress= false;
		super.CursorOver(pointer);
	}
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		System.out.println("cursorout");
		this.cursorOver=false;
		this.cursorPress=false;
		super.CursorOut(pointer);
	}
	

}
