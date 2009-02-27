package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;


/**
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public interface IMTControl {
	
	void DrawControl(PApplet app);
	
	void Resize(Dimension aSize);
	void Move(Point aLocation);
	
	void setZIndex(int aZIndex);
	int getZIndex();
	
	void addPointer(MTPointer pointer);
	void removePointer(MTPointer pointer);
	ArrayList<MTPointer> getPointers();

	Rectangle getRectangleArea();
}
