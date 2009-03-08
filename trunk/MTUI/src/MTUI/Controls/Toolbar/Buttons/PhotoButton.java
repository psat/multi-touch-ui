package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import MTUI.Constants.DrawConstants;
import MTUI.Controls.Shapes.MTPicture;
import MTUI.Processing.ProcessingApplet;
import MTUI.Utils.FilterImagesFile;


public class PhotoButton extends MTAbstractToolBarButton{
	private String mPicturesPath;
	public PhotoButton(String aPicturesPath){
		this.mPicturesPath = aPicturesPath;
		this.setImageBackground("/images/photos.jpg");
		
	}

	@Override
	public void CursorClicked() {
		
		//ProcessingApplet.getInstance().addControl(new MTEllipse(new Rectangle(80,80,100,100)));
		File PicturesPath = new File(this.mPicturesPath);
		
		
		String[] listPictures = PicturesPath.list(new FilterImagesFile());
		Random rand = new Random();
		
		for(String picFile : listPictures){
			int intWidth = rand.nextInt(DrawConstants.MAX_RANDOM_SIZE - DrawConstants.MIN_RANDOM_SIZE)+DrawConstants.MIN_RANDOM_POSITION;
			int intHeight = rand.nextInt(2*DrawConstants.MAX_RANDOM_SIZE_VARIATION) - DrawConstants.MAX_RANDOM_SIZE_VARIATION + intWidth;
			
			int intPosX = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
			int intPosY = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
			
			Rectangle PicBounds = new Rectangle(intPosX, intPosY, intWidth, intHeight);
			MTPicture picture = new MTPicture(this.mPicturesPath+"\\"+picFile, PicBounds);
			ProcessingApplet.getInstance().addControl(picture);
		}
	}
}
