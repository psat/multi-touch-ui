	package MTUI_WT.Controls;

import java.awt.event.MouseEvent;

import MTUI_CONST.AppletConst;
import processing.core.*;

public class MTToolBarButton extends MTAbstractControl {

	
	private static final long serialVersionUID = 1L;
	
	private String imgBackground;
	
	//events
    private boolean mouseOver;
    private boolean mousePressed;
	
	public void setImageBackground(String aImageLocation){
		this.imgBackground=aImageLocation;
	}
	@Override
	public void DrawControl(PApplet app) {

		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		if(this.mousePressed) app.fill(100);
		if(this.mouseOver) app.stroke(30);
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
		app.noStroke();
		if(!this.imgBackground.equals("")){
			PImage img = app.loadImage(this.imgBackground);
			app.image(img, this.getX()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getY()+AppletConst.TOOLBAR_BUTTON_MARGIN, this.getWidth()-2*AppletConst.TOOLBAR_BUTTON_MARGIN, this.getHeight()-2*AppletConst.TOOLBAR_BUTTON_MARGIN);
		
		}
	}

	public void setMouseOver(boolean value){
		this.mouseOver=value;
	}
	
	public void setMousePressed(boolean value){
		this.mousePressed = value;
	}
	public boolean getMousePressed(){
		return this.mousePressed;
	}
}
