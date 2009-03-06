package MTUI.Controls;

import java.awt.Rectangle;

import shapes.Rect;
import MTUI.Processing.ProcessingApplet;

public class RectangleButton extends MTAbstractToolBarButton {

	public RectangleButton(MTToolBar parent) {
		super(parent);
		this.setImageBackground("action.gif.jpg");
	}

	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new Rect(new Rectangle(80,80,100,100)));	
	}

}
