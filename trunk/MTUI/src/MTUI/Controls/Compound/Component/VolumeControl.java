package MTUI.Controls.Compound.Component;

import java.awt.Dimension;

import processing.core.PApplet;

public class VolumeControl extends MTAbstractCompoundComponent {

	public VolumeControl (){
		this.setReferenceSize(new Dimension(80,20));
	}
	@Override
	public void DrawControl(PApplet app) {
		app.fill(160,160,160);
		app.triangle(this.getX(), this.getY(), this.getX(), this.getY()+this.getHeight(), this.getX()+this.getWidth(), this.getY()+this.getHeight());
	}

}
