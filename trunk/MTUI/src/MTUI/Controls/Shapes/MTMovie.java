package MTUI.Controls.Shapes;

import java.awt.Rectangle;
import processing.core.*;
import processing.video.Movie;
import MTUI.Controls.MTAbstractControl;
import MTUI.Processing.ProcessingApplet;

public class MTMovie extends MTAbstractControl {

	Movie movie;
	
	public MTMovie(String aMoviePath){
		super();
		this.movie = new Movie(ProcessingApplet.getInstance(), aMoviePath);
	}
	
	@Override
	public void DrawControl(PApplet app) {
		app.image(this.movie, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
}
