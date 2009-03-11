package MTUI.Controls.Compound;

import java.awt.Button;
import java.awt.Point;
import java.awt.event.MouseEvent;

import MTUI.Controls.Compound.Component.ButtonLock;
import MTUI.Controls.Compound.Component.PianoKey;
import MTUI.Controls.Compound.Component.PianoSharpKey;
import MTUI.Controls.Compound.Component.VolumeControl;

import processing.core.PApplet;


public class MTPiano extends MTAbstractCompound {
	

	private static final long serialVersionUID = 1L;
	private boolean boolLock;
	
	public MTPiano(){
		
		//CompoundToolbar toolbar = new CompoundToolbar();
		
		PianoKey keyDo = new PianoKey(this);
		keyDo.setReferenceLocation(new Point(0,20));
		this.addControl(keyDo);
		
		PianoKey keyRe = new PianoKey(this);
		keyRe.setReferenceLocation(new Point(10,20));
		this.addControl(keyRe);
		
		PianoKey keyMi = new PianoKey(this);
		keyMi.setReferenceLocation(new Point(20,20));
		this.addControl(keyMi);
		
		PianoKey keyFa = new PianoKey(this);
		keyFa.setReferenceLocation(new Point(30,20));
		this.addControl(keyFa);
		
		PianoKey keySol = new PianoKey(this);
		keySol.setReferenceLocation(new Point(40,20));
		this.addControl(keySol);
		
		PianoKey keyLa = new PianoKey(this);
		keyLa.setReferenceLocation(new Point(50,20));
		this.addControl(keyLa);
		
		PianoKey keySi = new PianoKey(this);
		keySi.setReferenceLocation(new Point(60,20));
		this.addControl(keySi);
		
		PianoKey keyDo2 = new PianoKey(this);
		keyDo2.setReferenceLocation(new Point(70,20));
		this.addControl(keyDo2);
		
		PianoKey keyRe2 = new PianoKey(this);
		keyRe2.setReferenceLocation(new Point(80,20));
		this.addControl(keyRe2);
		
		PianoKey keyMi2 = new PianoKey(this);
		keyMi2.setReferenceLocation(new Point(90,20));
		this.addControl(keyMi2);
		
		PianoSharpKey sharpDo = new PianoSharpKey(this);
		sharpDo.setReferenceLocation(new Point(7,20));
		this.addControl(sharpDo);
		
		PianoSharpKey sharpRe = new PianoSharpKey(this);
		sharpRe.setReferenceLocation(new Point(17,20));
		this.addControl(sharpRe);
		
		PianoSharpKey sharpFa = new PianoSharpKey(this);
		sharpFa.setReferenceLocation(new Point(37,20));
		this.addControl(sharpFa);
		
		PianoSharpKey sharpSol = new PianoSharpKey(this);
		sharpSol.setReferenceLocation(new Point(47,20));
		this.addControl(sharpSol);
		
		PianoSharpKey sharpLa = new PianoSharpKey(this);
		sharpLa.setReferenceLocation(new Point(57,20));
		this.addControl(sharpLa);
		
		PianoSharpKey sharpDo2 = new PianoSharpKey(this);
		sharpDo2.setReferenceLocation(new Point(77,20));
		this.addControl(sharpDo2);
		
		PianoSharpKey sharpRe2 = new PianoSharpKey(this);
		sharpRe2.setReferenceLocation(new Point(87,20));
		this.addControl(sharpRe2);
		
		ButtonLock lock = new ButtonLock(this);
		lock.setReferenceLocation(new Point(0,0));
		this.addControl(lock);
		
		VolumeControl volume = new VolumeControl();
		volume.setReferenceLocation(new Point(20,0));
		this.addControl(volume);
		
	}
	public void Lock(){
		this.boolLock = true;
	}
	public void unLock(){
		this.boolLock = false;
	}
	
	@Override
	public void Move(int distX, int distY) {
		if(!this.boolLock)
			super.Move(distX, distY);
	}
	
	@Override
	public void Resize(int distX, int distY, int otherDistX, int otherDistY) {
		if(!this.boolLock)
			super.Resize(distX, distY, otherDistX, otherDistY);
	}

	@Override
	public void DrawControl(PApplet app) {
		super.DrawControl(app);
	}
}
