package mtui.controls.toolbar.buttons;

import java.awt.Rectangle;
import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.shapes.MTEllipse;
import mtui.controls.shapes.MTRectangle;
import mtui.controls.toolbar.MTToolbar;
import mtui.processing.ProcessingApplet;


public class EllipseButton extends MTAbstractToolbarButton {

	public EllipseButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "ellipse.gif");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTEllipse());
		
	}
}