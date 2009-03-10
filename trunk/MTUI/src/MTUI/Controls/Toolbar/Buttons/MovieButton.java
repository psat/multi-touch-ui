package MTUI.Controls.Toolbar.Buttons;

import java.awt.Rectangle;
import java.io.File;
import java.util.Random;

import MTUI.Config.ConfigFile;
import MTUI.Constants.DrawConstants;
import MTUI.Controls.Shapes.MTMovie;
import MTUI.Controls.Shapes.MTPicture;
import MTUI.Processing.ProcessingApplet;
import MTUI.Utils.FilterImagesFile;
import MTUI.Utils.FilterMoviesFile;

public class MovieButton extends MTAbstractToolBarButton{

	public MovieButton(){
		this.setImageBackground("/images/movies.gif");		
	
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
