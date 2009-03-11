package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;

import MTUI.Constants.AppletConst;
import MTUI.Controls.Shapes.MTEllipse;
import MTUI.Controls.Shapes.MTRectangle;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Processing.ProcessingApplet;

public class EllipseButton extends MTAbstractToolbarButton {

	public EllipseButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "ellipse.gif");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTEllipse());
		
	}
}