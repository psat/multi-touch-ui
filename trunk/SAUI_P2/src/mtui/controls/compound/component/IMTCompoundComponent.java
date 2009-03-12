package mtui.controls.compound.component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Interface that define component.
 * <p> Component are controls that defines a compound component. this kind of controls are similar and will extend the main control. 
 * <p> Main differences are related to the position and size once that components use reference positionand reference size to the parent, a compound component.
 * 
 * @author Nuno Santos
 *
 */
public interface IMTCompoundComponent {

	/**
	 * Get percentage position relative to parent location
	 * 
	 * @return (Point) Relative position to the parent size
	 */
	public Point getReferenceLocation();
	
	/**
	 * Set percentage position relative to parent location
	 * 
	 * @param location (Point) Relative position to the parent size
	 */
	public void setReferenceLocation(Point location);
	
	/**
	 * get the percentage that component occupies on parent
	 * 
	 * @return (Dimension) Percentage of parent size
	 */
	public Dimension getReferenceSize();
	
	/**
	 * set the percentage that component occupies on parent
	 * 
	 * @param size (Dimension) Percentage of parent size
	 */
	public void setReferenceSize(Dimension size);
	
	/**
	 * Set position and size in percentage of parent
	 * @param x (int) location in percentage
	 * @param y (int) location in percentage
	 * @param width (int) size in percentage 
	 * @param height (int) height in percentage
	 */
	public void setReferenceBounds(int x, int y, int width, int height);
	
	/**
	 * Transform the references position to real position in the canvas
	 * <p> The location and size are calculated with the percentages and the parent bounds
	 * 
	 * @param aParentBounds (Rectangle) Size and location of parent.
	 */
	public void UpdateSizeAndLocation(Rectangle aParentBounds);
}
