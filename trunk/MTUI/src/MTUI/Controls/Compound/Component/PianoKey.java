package MTUI.Controls.Compound.Component;

import java.awt.Color;
import java.awt.Dimension;

import MTUI.Controls.MTAbstractPointer;
import MTUI.Controls.Compound.MTAbstractCompound;

import processing.core.PApplet;

public class PianoKey extends MTAbstractCompoundComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PianoKey(MTAbstractCompound parent){
		this.setBackground(new Color(255,255,255));
		this.setReferenceSize(new Dimension(10,100));
	}

	@Override
	public void DrawControl(PApplet app) {
		app.stroke(0);
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(),this.getBackground().getBlue());
		
		if (cursorOver) app.fill(160,160,160);
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}

}
