package MTUI_WT.Compounds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import MTUI_WT.Compounds.Component.PianoKey;
import processing.core.PApplet;


public class MTPiano extends MTAbstractCompoundControl {
	

	private static final long serialVersionUID = 1L;
	
	public MTPiano(){
		
		Dimension dimWhiteKey = new Dimension(10,100);
		Dimension dimBlackKey = new Dimension(5,60);
		
		Color colWhite = new Color(0,0,0);
		Color colBlack = new Color(255,255,255);
		
		
		PianoKey keyDo = new PianoKey(this);
		keyDo.setLocation(new Point(0,0));
		this.addControl(keyDo);
		
		PianoKey keyRe = new PianoKey(this);
		keyRe.setLocation(new Point(10,0));
		this.addControl(keyDo);
		
		PianoKey keyMi = new PianoKey(this);
		keyMi.setLocation(new Point(20,0));
		this.addControl(keyDo);
		
		PianoKey keyFa = new PianoKey(this);
		keyFa.setLocation(new Point(30,0));
		this.addControl(keyDo);
		
		PianoKey keySol = new PianoKey(this);
		keySol.setLocation(new Point(40,0));
		this.addControl(keyDo);
		
		PianoKey keyLa = new PianoKey(this);
		keyLa.setLocation(new Point(50,0));
		this.addControl(keyDo);
		
		PianoKey keySi = new PianoKey(this);
		keySi.setLocation(new Point(60,0));
		this.addControl(keyDo);
		
		PianoKey keyDo2 = new PianoKey(this);
		keyDo2.setLocation(new Point(70,0));
		this.addControl(keyDo);
		
		PianoKey keyRe2 = new PianoKey(this);
		keyRe2.setLocation(new Point(80,0));
		this.addControl(keyDo);
		
		PianoKey keyMi2 = new PianoKey(this);
		keyMi2.setLocation(new Point(90,0));
		this.addControl(keyDo);
		
	}

	@Override
	public void DrawControl(PApplet app) {
		app.stroke(255);
		app.fill(255);
		//app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		super.DrawControl(app);
	}

}
