package mtui.controls.compound.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.sound.midi.MidiChannel;

import mtui.controls.compound.MTAbstractCompound;
import mtui.controls.compound.MTPiano;


import processing.core.PApplet;

public class PianoSharpKey extends MTAbstractPianoKey{

		public PianoSharpKey(MTPiano aPiano, int intKeyNum) {
			super(aPiano, intKeyNum);
			this.setBackground(new Color(0,0,0));
			this.setReferenceSize(new Dimension(6,45));
			this.setZIndex(1001);
		}

		private static final long serialVersionUID = 1L;

		@Override
		public void DrawControl(PApplet app) {
			app.fill(this.getBackground().getRed(), this.getBackground().getGreen(), this.getBackground().getBlue());
			
			super.DrawControl(app);
			app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			
		}


}
