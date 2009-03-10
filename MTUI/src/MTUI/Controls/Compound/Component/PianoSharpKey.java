package MTUI.Controls.Compound.Component;

import java.awt.Color;
import java.awt.Dimension;

import MTUI.Controls.Compound.MTAbstractCompound;

import processing.core.PApplet;

public class PianoSharpKey extends AbstractCompoundComponent{

		public PianoSharpKey(MTAbstractCompound parent) {
			super(parent);
			this.setBackground(new Color(0,0,0));
			this.setSize(new Dimension(6,60));
		}

		private static final long serialVersionUID = 1L;

		@Override
		public void DrawControl(PApplet app) {
			app.fill(this.getBackground().getRed(), this.getBackground().getGreen(), this.getBackground().getBlue());
			app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			
		}


}
