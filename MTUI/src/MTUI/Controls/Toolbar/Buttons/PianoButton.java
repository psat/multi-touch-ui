package MTUI.Controls.Toolbar.Buttons;

import java.io.File;

import MTUI.Constants.AppletConst;
import MTUI.Controls.Compound.MTPiano;
import MTUI.Processing.ProcessingApplet;

public class PianoButton extends MTAbstractToolbarButton {

	public PianoButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "piano.jpg");
	}
	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTPiano());
		
	}

}
