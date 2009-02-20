package MTUI_WT.Controls;

import java.awt.*;
import java.awt.event.MouseEvent;

import processing.core.PApplet;

public abstract class MTAbstractControl extends Component implements IMTControl {
	
	private static final long serialVersionUID = 1L;

	public void Resize(Dimension aSize){
	
	}
	
	public void Move(Point aLocation){
		
	}

	public abstract void DrawControl(PApplet app);

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e){}
	
	@Override
	public void mouseClicked(MouseEvent e) {}


	@Override
	public void mouseEntered(MouseEvent e) {}


	@Override
	public void mouseExited(MouseEvent e) {}


	@Override
	public void mousePressed(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {}

}
