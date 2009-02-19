package MTUI_WT.Controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import org.w3c.dom.events.MouseEvent;

import processing.core.PApplet;

public interface IMTControl extends MouseListener{

	void DrawControl(PApplet app);
	
}