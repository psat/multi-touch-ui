package MTUI.Controls.Compound.Component;

import java.awt.Dimension;
import java.awt.Point;

import MTUI.Constants.AppletConst;
import MTUI.Constants.PianoConst;
import MTUI.Controls.Compound.MTPiano;

import processing.core.PApplet;

public class VolumeSlider extends MTAbstractCompoundComponent {

	private MTPiano mPiano;
	public VolumeSlider(MTPiano aPiano){
		this.mPiano = aPiano;
		this.setReferenceSize(new Dimension(6,106));
		
		this.setReferenceLocation(new Point(getPositionFromVolume(), -3));
	}
	@Override
	public void DrawControl(PApplet app) {
		app.stroke(0);
		app.fill(100,100,100);
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		System.out.println(this.getX());
		
	}
	
	public int getPositionFromVolume(){
		int valX = (this.mPiano.getMidi().getController(PianoConst.REGISTER_CHANGE_VOLUME)
			*(100 - 6))
			/PianoConst.VOLUME_MAX_VALUE;
		
		return valX;
	}

}
