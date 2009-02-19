package MTUI_WT.Controls;

import processing.core.PApplet;

public class MTToolBarButton extends MTAbstractControl {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void DrawControl(PApplet app) {

		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());

		
	}

}
