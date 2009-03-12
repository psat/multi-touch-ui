package mtui.controls.toolbar.buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import mtui.config.ConfigFile;
import mtui.constants.AppletConst;
import mtui.constants.DrawConstants;
import mtui.controls.shapes.MTPicture;
import mtui.processing.ProcessingApplet;
import mtui.utils.FilterImagesFile;


/**
 * Extended class of mtui.controls.toolbar.buttons.MTAbstractToolbarButton.
 * 
 * Have the button characteristics for the photo as the cursor click event.
 * 
 * @see mtui.controls.toolbar.buttons.MTAbstractToolbarButton
 * @author Nuno Santos
 *
 */
public class PhotoButton extends MTAbstractToolbarButton{
	public PhotoButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "pictures.gif");		
	}

	@Override
	public void CursorClicked() {
		
		File PicturesPath = new File(ConfigFile.getPicturesPath());
		
		if(!PicturesPath.exists()){
			System.out.println("Invalid path for pictures. Pleese choose in menu bar: Media>Set pictures path");
			return;
		}
		
		String[] listPictures = PicturesPath.list(new FilterImagesFile());
		
		for(String picFile : listPictures){
		MTPicture picture = new MTPicture(PicturesPath.getAbsolutePath()+File.separator+picFile);
			ProcessingApplet.getInstance().addControl(picture);
		}
	}
}
