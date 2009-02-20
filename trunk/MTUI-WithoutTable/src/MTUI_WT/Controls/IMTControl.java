package MTUI_WT.Controls;


import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import processing.core.PApplet;

public interface IMTControl extends MouseMotionListener, MouseListener{

	void DrawControl(PApplet app);
	
	void Resize(Dimension aSize);
	void Move(Point aLocation);
	
}