package mtui.controls.compound.component;

import javax.sound.midi.MidiChannel;

import mtui.constants.AppletConst;
import mtui.constants.PianoConst;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.MTPiano;

import processing.core.PApplet;

public class MTAbstractPianoKey extends MTAbstractCompoundComponent{

	private int intKeyNum;
	private MTPiano mPiano;
	private boolean boolKeyPlayed;
	
	public MTAbstractPianoKey(MTPiano aPiano, int intKeyNum){
		this.intKeyNum = intKeyNum;
		this.mPiano = aPiano;
	}
	
	@Override
	public void DrawControl(PApplet app) {
		if (cursorOver && this.mPiano.IsLocked()){
			app.fill(160,160,160);
			if(!this.boolKeyPlayed){
				this.mPiano.getMidi().noteOn(this.intKeyNum, PianoConst.NOTE_VELOCITY);
				this.boolKeyPlayed=true;
			}
		}
		
	}
	
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		
		System.out.println("piano");
		
		this.boolKeyPlayed=false;
		super.CursorOut(pointer);
		
	}

}
