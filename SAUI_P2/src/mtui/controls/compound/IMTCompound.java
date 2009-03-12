package mtui.controls.compound;

import mtui.controls.ICursorEvents;
import mtui.controls.IMTControl;
import mtui.controls.compound.component.MTAbstractCompoundComponent;

public interface IMTCompound extends IMTControl {

	void addControl(MTAbstractCompoundComponent control);
}
