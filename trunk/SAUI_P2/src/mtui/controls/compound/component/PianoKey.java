package mtui.controls.compound.component;

import java.awt.Color;
import java.awt.Dimension;

import mtui.constants.PianoConst;
import mtui.controls.compound.MTPiano;


import processing.core.PApplet;

public class PianoKey extends MTAbstractPianoKey{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PianoKey(MTPiano aPiano, int intKeyNum){
		super(aPiano, intKeyNum);
	
		this.setZIndex(1000);
		this.setBackground(new Color(255,255,255));
		this.setReferenceSize(new Dimension(PianoConst.KEY_WIDTH,PianoConst.KEY_HEIGHT));
	}

	@Override
	public void DrawControl(PApplet app) {
		app.stroke(0);
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(),this.getBackground().getBlue());
		
		super.DrawControl(app);
	
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}
	

}
