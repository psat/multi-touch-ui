package MTUI.Controls.Shapes;

import java.awt.Rectangle;
import processing.core.*;
import quicktime.std.movies.Movie;
import MTUI.Processing.ProcessingApplet;

public class MTMovie extends MTAbstractShape {

	Movie movie;
	
	public MTMovie(String aPicturePath, Rectangle aBounds){
		this.movie = new Movie()
		this.setBounds(aBounds);
		
	}
	@Override
	public void DrawControl(PApplet app) {
		app.image(this.mPicture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
