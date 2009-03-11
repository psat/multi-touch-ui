package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;

import MTUI.Constants.AppletConst;
import MTUI.Controls.Shapes.MTRectangle;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Processing.ProcessingApplet;

public class RectangleButton extends MTAbstractToolbarButton {

	public RectangleButton() {
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "Rectangle.jpg");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTRectangle());	
	}

	

}
