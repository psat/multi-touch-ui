package MTUI.Controls.Compound.Component;


import java.awt.Dimension;
import java.awt.Point;


import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.Compound.MTAbstractCompound;

public abstract class AbstractCompoundComponent extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	private MTAbstractCompound mParent;
	private Dimension refSize;
	private Point refLocation;
	
	public AbstractCompoundComponent(MTAbstractCompound parent)
	{
		this.mParent=parent;
	}
	

	public MTAbstractCompound getMainControl(){
		return this.mParent;
	}
	
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
	
	public void UpdateSizeAndLocation(){
		int newX = (int) (this.mParent.getX() + (this.getReferenceLocation().getX()*this.mParent.getWidth())/100);
		int newY = (int) (this.mParent.getY() + (this.getReferenceLocation().getY()*this.mParent.getHeight())/100);
		super.setLocation(newX, newY);
		
		int newWidth = (int) (this.mParent.getWidth()*this.getReferenceSize().getWidth()/100);
		int newHeight = (int) (this.mParent.getHeight()*this.getReferenceSize().getHeight()/100);
	
		super.setSize(new Dimension(newWidth, newHeight));
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.setReferenceLocation(new Point(x,y));
		
		int newX = (int) (this.mParent.getX() + (this.getReferenceLocation().getX()*this.mParent.getWidth())/100);
		int newY = (int) (this.mParent.getY() + (this.getReferenceLocation().getY()*this.mParent.getHeight())/100);
		super.setLocation(newX, newY);
	}

	@Override
	public void setSize(Dimension d) {
		this.setReferenceSize(d);
		
		int newWidth = (int) (this.mParent.getWidth()*this.getReferenceSize().getWidth()/100);
		int newHeight = (int) (this.mParent.getHeight()*this.getReferenceSize().getHeight()/100);
	
		super.setSize(new Dimension(newWidth, newHeight));
		
	}
	
	@Override
	public void Move(int distX, int distY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Resize(int distX, int distY, int otherDistX,
			int intOtherDistY) {
		// TODO Auto-generated method stub
		
	}
	

}
