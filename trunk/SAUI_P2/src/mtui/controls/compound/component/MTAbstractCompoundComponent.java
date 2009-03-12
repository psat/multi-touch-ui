package mtui.controls.compound.component;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.MTAbstractCompound;



public abstract class MTAbstractCompoundComponent extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	private Dimension refSize;
	private Point refLocation;
	protected boolean cursorOver;
	protected boolean cursorPress;
	
	public Point getReferenceLocation(){
		
		return this.refLocation;
	}
	
	public void setReferenceLocation(Point location){
		
		this.refLocation =location;
	}
	
	public Dimension getReferenceSize(){
		return this.refSize;
	}
	public void setReferenceSize(Dimension size){
		this.refSize=size;
	}
	public void setReferenceBounds(int x, int y, int width, int height){
		this.setReferenceLocation(new Point(x,y));
		this.setReferenceSize(new Dimension(width, height));
	}
	
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
