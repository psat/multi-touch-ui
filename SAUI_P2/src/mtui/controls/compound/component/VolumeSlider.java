package mtui.controls.compound.component;

import java.awt.Dimension;
import java.awt.Point;

import mtui.constants.PianoConst;
import mtui.controls.compound.MTPiano;


import processing.core.PApplet;

/**
 * Extended class from <b>mtui.control.compound.component.MTAbstractCompoundComponent</b>
 * <p>
 * Defines a slider for a volume control from piano.
 * 
 * @see mtui.control.compound.componet.MTAbstractCompoundComponent
 * 
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
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
		
	}
	/**
	 * 
	 * Reads the midi channel volume and obtain slider position related to that volume
	 * 
	 * @return (int) the reference position associated to the midi volume
	 */
	public int getPositionFromVolume(){
		int valX = (this.mPiano.getMidi().getController(PianoConst.REGISTER_CHANGE_VOLUME)
			*(100 - 6))
			/PianoConst.VOLUME_MAX_VALUE;
		
		return valX;
	}
	/**
	 * Set volume value from the slider position
	 * 
	 * @param posX (int) Value of the reference position at the xx axis
	 */
	public void setMidiVolumeFromPosition(int posX){
		int volume = (int)((posX *PianoConst.VOLUME_MAX_VALUE)/100);
		this.mPiano.getMidi().controlChange(PianoConst.REGISTER_CHANGE_VOLUME, volume);
	}
	@Override
	public void setReferenceLocation(Point location) {
		this.setMidiVolumeFromPosition((int)location.getX());
		super.setReferenceLocation(location);
	}

}
