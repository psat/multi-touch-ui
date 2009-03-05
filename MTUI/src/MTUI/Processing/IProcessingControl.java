package MTUI.Processing;

import processing.core.PApplet;

public interface IProcessingControl {
	
	void DrawControl(PApplet aApp);
	
	void setZIndex(int aZIndex);
	int getZIndex();
}
