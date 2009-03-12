package mtui.controls.toolbar.buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import mtui.config.ConfigFile;
import mtui.constants.AppletConst;
import mtui.constants.DrawConstants;
import mtui.controls.shapes.MTMovie;
import mtui.controls.shapes.MTPicture;
import mtui.processing.ProcessingApplet;
import mtui.utils.FilterImagesFile;
import mtui.utils.FilterMoviesFile;


public class MovieButton extends MTAbstractToolbarButton{

	public MovieButton(){
		this.setImageBackground(AppletConst.IMAGES_PATH + File.separator + "movies.gif");		
	
	}
	@Override
	public void CursorClicked() {
		File MoviesPath = new File(ConfigFile.getMoviesPath());
		
		if(!MoviesPath.exists()){
			System.out.println("Invalid path for movies. Pleese choose in menu bar: Media>Set MOVIES path");
			return;
		}
		
		String[] listMovies = MoviesPath.list(new FilterMoviesFile());
		
		for(String movFile : listMovies){
			MTMovie movie = new MTMovie(MoviesPath.getAbsolutePath()+File.separator+movFile);
			ProcessingApplet.getInstance().addControl(movie);
		}
		
	}
	

}
