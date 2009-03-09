package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import MTUI.Constants.DrawConstants;
import MTUI.Controls.Shapes.MTPicture;
import MTUI.Processing.ProcessingApplet;
import MTUI.Utils.FilterImagesFile;

public class MovieButton extends MTAbstractToolBarButton{

	public MovieButton(){
		this.setImageBackground("/images/movie.jpg");		
	
	}
	@Override
	public void CursorClicked() {
		File MoviesPath = new File(ProcessingApplet.getInstance().getMoviesPath());
		
		if(!MoviesPath.exists()){
			System.out.println("Invalid path for pictures. Pleese choose in menu bar: Media>Set pictures path");
			return;
		}
		
		String[] listMovies = MoviesPath.list(new FilterImagesFile());
		Random rand = new Random();
		
		for(String picFile : listMovies){
			
			
			int intWidth = rand.nextInt(DrawConstants.MAX_RANDOM_SIZE - DrawConstants.MIN_RANDOM_SIZE)+DrawConstants.MIN_RANDOM_POSITION;
			int intHeight = rand.nextInt(2*DrawConstants.MAX_RANDOM_SIZE_VARIATION) - DrawConstants.MAX_RANDOM_SIZE_VARIATION + intWidth;
			
			int intPosX = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
			int intPosY = rand.nextInt(DrawConstants.MAX_RANDOM_POSITION - DrawConstants.MIN_RANDOM_POSITION) + DrawConstants.MIN_RANDOM_POSITION;
			
			Rectangle PicBounds = new Rectangle(intPosX, intPosY, intWidth, intHeight);
			MTMovie movie = new MTMovie(MoviesPath.getAbsolutePath()+File.separator+movFile, PicBounds);
			ProcessingApplet.getInstance().addControl(movie);
		}
		
	}
	

}
