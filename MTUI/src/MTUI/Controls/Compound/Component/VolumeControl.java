package MTUI.Controls.Compound.Component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import MTUI.Constants.AppletConst;
import MTUI.Constants.DrawConstants;
import MTUI.Constants.PianoConst;
import MTUI.Controls.MTAbstractPointer;
import MTUI.Controls.Compound.MTPiano;

import processing.core.PApplet;

public class VolumeControl extends MTAbstractCompoundComponent {

	VolumeSlider slider;
	private MTPiano mPiano;
	private Rectangle rBounds4Slider;
	public VolumeControl (MTPiano aPiano){
		this.mPiano = aPiano;
		this.setReferenceSize(new Dimension(80,20));
		slider = new VolumeSlider(aPiano);
		
	
	}
	@Override
	public void DrawControl(PApplet app) {
		
		app.noStroke();
		app.fill(209,221,222);
		app.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		app.fill(160,160,160);
	
		
		//remove margins for slider handler
		rBounds4Slider = new Rectangle(this.getX() + 2*AppletConst.TOOLBAR_BUTTON_MARGIN,
				this.getY() + 2*AppletConst.TOOLBAR_BUTTON_MARGIN,
				this.getWidth()- 4*AppletConst.TOOLBAR_BUTTON_MARGIN,
				this.getHeight()- 4*AppletConst.TOOLBAR_BUTTON_MARGIN);
		
		
		app.triangle((float)this.rBounds4Slider.getX(), 
				(float)(this.rBounds4Slider.getY() + this.rBounds4Slider.getHeight()), 
				(float)(this.rBounds4Slider.getX()+this.rBounds4Slider.getWidth()), 
				(float)this.rBounds4Slider.getY(), 
				(float)(this.rBounds4Slider.getX() + this.rBounds4Slider.getWidth()), 
				(float)(this.rBounds4Slider.getY() + this.rBounds4Slider.getHeight()));
		
		app.fill(255,0,0);
			
		slider.UpdateSizeAndLocation(rBounds4Slider);
		slider.DrawControl(app);
	}
	
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		if(this.mPiano.IsLocked()){
			int newRefPos = (int)((pointer.getX()-this.rBounds4Slider.getX())*100/this.rBounds4Slider.getWidth());
			if(newRefPos<96)
				this.slider.setReferenceLocation(new Point(newRefPos, -3));
		}
	
		super.CursorAdd(pointer);
	}
	
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		if(this.mPiano.IsLocked()){
			int newRefPos = (int)((pointer.getX()-this.rBounds4Slider.getX())*100/this.rBounds4Slider.getWidth());
			if(newRefPos<96)
				this.slider.setReferenceLocation(new Point(newRefPos, -3));
		}
		super.CursorOver(pointer);
	}

}
