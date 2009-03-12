package mtui.controls.shapes;

import java.awt.Rectangle;

import mtui.controls.MTAbstractControl;
import mtui.processing.ProcessingApplet;
import processing.core.*;
import processing.video.Movie;

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
