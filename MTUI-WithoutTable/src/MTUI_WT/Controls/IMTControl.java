package MTUI_WT.Controls;


import java.awt.*;
import processing.core.PApplet;

public interface IMTControl{

	void DrawControl(PApplet app);
	
	void Resize(Dimension aSize);
	void Move(Point aLocation);
	
}