package MTUI.Controls.Compound;

import MTUI.Controls.ICursorEvents;
import MTUI.Controls.IMTControl;
import MTUI.Controls.Compound.Component.MTAbstractCompoundComponent;

public interface IMTCompound extends IMTControl, ICursorEvents {

	void addControl(MTAbstractCompoundComponent control);
}
