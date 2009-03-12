package mtui.controls.compound;

import java.util.ArrayList;
import java.util.Collections;

import mtui.controls.MTAbstractControl;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.IMTCompound;
import mtui.controls.compound.component.MTAbstractCompoundComponent;
import mtui.utils.byInverseZIndex;

import processing.core.PApplet;

/**
 * Extended class from <b> MTAbstractControl</b> and implements <b>IMTCompound</b>
 * 
 * All compound controls should extend this abstract class.
 * <p>
 * This class implements the manage of child controls and the respective cursors events.
 * <p>
 * Bounds are overridden in order to set bounds to child controls
 * 
 * @author Nuno Santos
 *
 */
@SuppressWarnings("serial")
public class MTAbstractCompound extends MTAbstractControl implements IMTCompound {

	/**
	 * protected property saving lock state of the compound component.  
	 */
	protected boolean boolLock;
	
	/**
	 * Collection of the controls that compound components is composed
	 */
	protected ArrayList<MTAbstractCompoundComponent> Controls = new ArrayList<MTAbstractCompoundComponent>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void DrawControl(PApplet app) {
		for(MTAbstractCompoundComponent component : (ArrayList<MTAbstractCompoundComponent>)this.Controls.clone()){
			component.DrawControl(app);	
		}
	}

	@Override
	public void addControl(MTAbstractCompoundComponent control) {
		control.UpdateSizeAndLocation(this.getBounds());
		if(control.getBackground()==null) control.setBackground(this.getBackground());
		this.Controls.add(control);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		if(this.Controls!=null){
			for(MTAbstractCompoundComponent component: this.Controls)
				component.UpdateSizeAndLocation(this.getBounds());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		super.CursorAdd(pointer);
		ArrayList<MTAbstractCompoundComponent> clone =(ArrayList<MTAbstractCompoundComponent>) this.Controls.clone();
		Collections.sort(clone, new byInverseZIndex());
		for(MTAbstractCompoundComponent component : clone)
			if(component.getBounds().intersects(pointer.getBounds())){
				component.CursorAdd(pointer);
				pointer.setCurrentCompoundControl(component);
				break;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		super.CursorOver(pointer);
		
		
		ArrayList<MTAbstractCompoundComponent> clone =(ArrayList<MTAbstractCompoundComponent>) this.Controls.clone();
		Collections.sort(clone, new byInverseZIndex());
		for(MTAbstractCompoundComponent component : clone)
			if(component.getBounds().intersects(pointer.getBounds())){
				component.CursorOver(pointer);
				pointer.setCurrentCompoundControl(component);
				break;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		super.CursorOut(pointer);
		for(MTAbstractCompoundComponent component : 
						(ArrayList<MTAbstractCompoundComponent>) this.Controls.clone())
			if(component.getBounds().intersects(pointer.getBounds()))
				component.CursorOut(pointer);
	}
	@Override
	public void Lock(){
		this.boolLock = true;
	}

	@Override
	public void unLock(){
		this.boolLock = false;
	}
	@Override
	public boolean IsLocked(){
		return this.boolLock;
	}
	




}
