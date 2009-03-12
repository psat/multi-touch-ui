package MTUI.Controls.Compound;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;
import MTUI.Controls.Compound.IMTCompound;
import MTUI.Controls.Compound.Component.MTAbstractCompoundComponent;
import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.MTAbstractPointer;
import MTUI.Utils.byInverseZIndex;

public class MTAbstractCompound extends MTAbstractControl implements IMTCompound {

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
	




}
