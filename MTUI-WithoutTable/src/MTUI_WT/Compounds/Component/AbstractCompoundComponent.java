package MTUI_WT.Compounds.Component;


import java.awt.Dimension;

import MTUI_WT.Compounds.IMTCompoundControl;
import MTUI_WT.Compounds.MTAbstractCompoundControl;
import MTUI_WT.Controls.MTAbstractControl;

public abstract class AbstractCompoundComponent extends MTAbstractControl{

	private static final long serialVersionUID = 1L;
	private MTAbstractCompoundControl mParent;
	
	public AbstractCompoundComponent(MTAbstractCompoundControl parent)
	{
		this.mParent=parent;
	}
	

	public MTAbstractCompoundControl getMainControl(){
		return this.mParent;
	}
	
	
		
	@Override
	public void setLocation(int x, int y) {
		int newX = this.mParent.getX() + (x*this.mParent.getWidth())/100;
		int newY = this.mParent.getY() + (y*this.mParent.getHeight())/100;
		super.setLocation(newX, newY);
	}
	
	@Override
	public void setSize(Dimension d) {
		int newWidth = (int) (this.mParent.getWidth()*d.getWidth()/100);
		int newHeight = (int) (this.mParent.getHeight()*d.getHeight()/100);
	
		super.setSize(new Dimension(newWidth, newHeight));
		
	}

}
