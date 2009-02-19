package MTUI_WT.Controls;

import java.awt.*;
import java.awt.event.MouseEvent;

import processing.core.*;

public abstract class MTAbstractControl extends Component implements IMTControl {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public abstract void DrawControl(PApplet app);

	
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
