package MTUI.Controls.Compound.Component;

import java.awt.Color;
import java.awt.Dimension;

import MTUI.Controls.Compound.MTAbstractCompound;

import processing.core.PApplet;

public class PianoSharpKey extends MTAbstractCompoundComponent{

		public PianoSharpKey(MTAbstractCompound parent) {
			this.setBackground(new Color(0,0,0));
			this.setReferenceSize(new Dimension(6,45));
		}

		private static final long serialVersionUID = 1L;

		@Override
		public void DrawControl(PApplet app) {
			app.fill(this.getBackground().getRed(), this.getBackground().getGreen(), this.getBackground().getBlue());
			if (cursorOver) app.fill(160,160,160);
			app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			
		}


}
