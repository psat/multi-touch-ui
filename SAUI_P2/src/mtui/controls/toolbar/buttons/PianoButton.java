package mtui.controls.toolbar.buttons;

import java.io.File;

import mtui.constants.AppletConst;
import mtui.controls.compound.MTPiano;
import mtui.processing.ProcessingApplet;


/**
 * Extended class of mtui.controls.toolbar.buttons.MTAbstractToolbarButton.
 * 
 * Have the button characteristics for the piano as the cursor click event.
 * 
 * @see mtui.controls.toolbar.buttons.MTAbstractToolbarButton
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
public class PianoButton extends MTAbstractToolbarButton {

	public PianoButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "piano.jpg");
	}
	@Override
	public void CursorClicked() {
		ProcessingApplet.getInstance().addControl(new MTPiano());
		
	}

}
