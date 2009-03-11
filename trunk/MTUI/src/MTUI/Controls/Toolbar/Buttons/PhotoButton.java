package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import MTUI.Config.ConfigFile;
import MTUI.Constants.AppletConst;
import MTUI.Constants.DrawConstants;
import MTUI.Controls.Shapes.MTPicture;
import MTUI.Processing.ProcessingApplet;
import MTUI.Utils.FilterImagesFile;


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
