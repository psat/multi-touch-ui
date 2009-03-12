package MTUI.Controls.Compound.Component;

import javax.sound.midi.MidiChannel;

import MTUI.Constants.AppletConst;
import MTUI.Constants.PianoConst;
import MTUI.Controls.MTAbstractPointer;
import MTUI.Controls.Compound.MTPiano;
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
