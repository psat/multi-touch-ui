package MTUI.Controls.Compound;

import java.awt.Point;
import java.awt.event.MouseEvent;

import MTUI.Controls.Compound.Component.PianoKey;
import MTUI.Controls.Compound.Component.PianoSharpKey;

import processing.core.PApplet;


public class MTPiano extends MTAbstractCompound {
	

	private static final long serialVersionUID = 1L;
	
	public MTPiano(){
			
		
		PianoKey keyDo = new PianoKey(this);
		keyDo.setLocation(new Point(0,0));
		this.addControl(keyDo);
		
		PianoKey keyRe = new PianoKey(this);
		keyRe.setLocation(new Point(10,0));
		this.addControl(keyRe);
		
		PianoKey keyMi = new PianoKey(this);
		keyMi.setLocation(new Point(20,0));
		this.addControl(keyMi);
		
		PianoKey keyFa = new PianoKey(this);
		keyFa.setLocation(new Point(30,0));
		this.addControl(keyFa);
		
		PianoKey keySol = new PianoKey(this);
		keySol.setLocation(new Point(40,0));
		this.addControl(keySol);
		
		PianoKey keyLa = new PianoKey(this);
		keyLa.setLocation(new Point(50,0));
		this.addControl(keyLa);
		
		PianoKey keySi = new PianoKey(this);
		keySi.setLocation(new Point(60,0));
		this.addControl(keySi);
		
		PianoKey keyDo2 = new PianoKey(this);
		keyDo2.setLocation(new Point(70,0));
		this.addControl(keyDo2);
		
		PianoKey keyRe2 = new PianoKey(this);
		keyRe2.setLocation(new Point(80,0));
		this.addControl(keyRe2);
		
		PianoKey keyMi2 = new PianoKey(this);
		keyMi2.setLocation(new Point(90,0));
		this.addControl(keyMi2);
		
		PianoSharpKey sharpDo = new PianoSharpKey(this);
		sharpDo.setLocation(new Point(7,0));
		this.addControl(sharpDo);
		
		PianoSharpKey sharpRe = new PianoSharpKey(this);
		sharpRe.setLocation(new Point(17,0));
		this.addControl(sharpRe);
		
		PianoSharpKey sharpFa = new PianoSharpKey(this);
		sharpFa.setLocation(new Point(37,0));
		this.addControl(sharpFa);
		
		PianoSharpKey sharpSol = new PianoSharpKey(this);
		sharpSol.setLocation(new Point(47,0));
		this.addControl(sharpSol);
		
		PianoSharpKey sharpLa = new PianoSharpKey(this);
		sharpLa.setLocation(new Point(57,0));
		this.addControl(sharpLa);
		
		PianoSharpKey sharpDo2 = new PianoSharpKey(this);
		sharpDo2.setLocation(new Point(77,0));
		this.addControl(sharpDo2);
		
		PianoSharpKey sharpRe2 = new PianoSharpKey(this);
		sharpRe2.setLocation(new Point(87,0));
		this.addControl(sharpRe2);
		
	}

	@Override
	public void DrawControl(PApplet app) {
		super.DrawControl(app);
	}
}
