package mtui.controls.toolbar.buttons;

import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTPiano;
import mtui.processing.ProcessingApplet;


public class PianoButton extends MTAbstractToolbarButton {

	public PianoButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "piano.jpg");
	}
	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTPiano());
		
	}

}
