package mtui.controls.compound.component;

import mtui.constants.PianoConst;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.MTPiano;

import processing.core.PApplet;

/**
 * Abstract class extended from <b>mtui.control.compound.component.MTAbstractCompoundComponent</b>
 * <p>
 * Defines the piano key as a compound component and differs from other components once that have the responsibility of play midi notes
 * 
 * @see mtui.control.compound.componet.MTAbstractCompoundComponent
 * 
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
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
		this.boolKeyPlayed=false;
		super.CursorOut(pointer);
		
	}

}
