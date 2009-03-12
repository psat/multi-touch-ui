package mtui.controls.toolbar.buttons;

import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.shapes.MTRectangle;
import mtui.processing.ProcessingApplet;


public class RectangleButton extends MTAbstractToolbarButton {

	public RectangleButton() {
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "Rectangle.jpg");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTRectangle());	
	}

	

}
