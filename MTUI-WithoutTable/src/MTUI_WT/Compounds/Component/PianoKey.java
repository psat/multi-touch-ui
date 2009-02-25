package MTUI_WT.Compounds.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import processing.core.PApplet;

import MTUI_WT.Compounds.IMTCompoundControl;
import MTUI_WT.Compounds.MTAbstractCompoundControl;

public class PianoKey extends AbstractCompoundComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PianoKey(MTAbstractCompoundControl parent){
		super(parent);
		this.setBackground(new Color(255,255,255));
		this.setSize(new Dimension(10,100));
	}

	@Override
	public void DrawControl(PApplet app) {
		app.stroke(0);
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(),this.getBackground().getBlue());
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
}
