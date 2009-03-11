package MTUI.Controls.Compound.Component;

import java.awt.Dimension;

import processing.core.PApplet;

public class VolumeSlider extends MTAbstractCompoundComponent {

	public VolumeSlider(){
		this.setReferenceSize(new Dimension(6,80));
	}
	@Override
	public void DrawControl(PApplet app) {
		app.stroke(0);
		app.fill(100,100,100);
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}

}
