package MTUI.Controls.Compound.Component;

import java.awt.Dimension;
import java.awt.Point;

import MTUI.Constants.AppletConst;
import MTUI.Constants.DrawConstants;

import processing.core.PApplet;

public class VolumeControl extends MTAbstractCompoundComponent {

	VolumeSlider slider;
	public VolumeControl (){
		this.setReferenceSize(new Dimension(80,20));
		slider = new VolumeSlider();
		slider.setReferenceLocation(new Point(20, 2*AppletConst.TOOLBAR_BUTTON_MARGIN +1));
	}
	@Override
	public void DrawControl(PApplet app) {
		
		app.noStroke();
		app.fill(255,255,255);
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		app.fill(160,160,160);
		app.triangle(this.getX() + 2*AppletConst.TOOLBAR_BUTTON_MARGIN, 
				this.getY()+this.getHeight() - 2*AppletConst.TOOLBAR_BUTTON_MARGIN, 
				this.getX()+this.getWidth()- 2*AppletConst.TOOLBAR_BUTTON_MARGIN, 
				this.getY() + 2*AppletConst.TOOLBAR_BUTTON_MARGIN, 
				this.getX()+this.getWidth()- 2*AppletConst.TOOLBAR_BUTTON_MARGIN, 
				this.getY()+this.getHeight()- 2*AppletConst.TOOLBAR_BUTTON_MARGIN);
		
		slider.UpdateSizeAndLocation(this.getBounds());
		slider.DrawControl(app);
	}

}
