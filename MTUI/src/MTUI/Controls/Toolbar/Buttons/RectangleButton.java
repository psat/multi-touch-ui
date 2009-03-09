package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;

import MTUI.Controls.Shapes.MTRectangle;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Processing.ProcessingApplet;

public class RectangleButton extends MTAbstractToolBarButton {

	public RectangleButton() {
		this.setImageBackground("/images/Rectangle.jpg");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTRectangle(new Rectangle(80,80,100,100)));	
	}

	

}
