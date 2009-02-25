package MTUI_WT.Compounds;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import processing.core.PApplet;

import MTUI_WT.Compounds.Component.AbstractCompoundComponent;
import MTUI_WT.Controls.IMTControl;
import MTUI_WT.Controls.MTAbstractControl;

public abstract class MTAbstractCompoundControl extends MTAbstractControl implements IMTCompoundControl  {
	

	private static final long serialVersionUID = 1L;
	ArrayList<AbstractCompoundComponent> Controls = new ArrayList<AbstractCompoundComponent>();
	
	@Override
	public void addControl(AbstractCompoundComponent control) {
		this.Controls.add(control);
	}

	@Override
	public void removeControl(AbstractCompoundComponent control) {
		this.Controls.remove(control);
	}


	@Override
	public void Move(Point location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void DrawControl(PApplet app) {
		for(AbstractCompoundComponent component : this.Controls)
			component.DrawControl(app);
	}
	
}
