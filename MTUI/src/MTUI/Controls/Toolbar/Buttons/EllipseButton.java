package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;

import MTUI.Controls.Shapes.MTEllipse;
import MTUI.Controls.Shapes.MTRectangle;
import MTUI.Controls.Toolbar.MTToolBar;
import MTUI.Processing.ProcessingApplet;

public class EllipseButton extends MTAbstractToolBarButton {

	public EllipseButton(){
		this.setImageBackground("/images/ellipse.gif");

	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTEllipse(new Rectangle(80,80,100,100)));
		
	}
}