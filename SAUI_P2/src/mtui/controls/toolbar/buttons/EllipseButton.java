package mtui.controls.toolbar.buttons;

import java.awt.Rectangle;
import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTToolbar;
import mtui.controls.shapes.MTEllipse;
import mtui.controls.shapes.MTRectangle;
import mtui.processing.ProcessingApplet;

/**
 * Extended class of mtui.controls.toolbar.buttons.MTAbstractToolbarButton.
 * 
 * Have the button characteristics for the ellipse as the cursor click event.
 * 
 * @see mtui.controls.toolbar.buttons.MTAbstractToolbarButton
 * @author Nuno Santos
 *
 */
public class EllipseButton extends MTAbstractToolbarButton {

	public EllipseButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "ellipse.gif");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTEllipse());
		
	}
}