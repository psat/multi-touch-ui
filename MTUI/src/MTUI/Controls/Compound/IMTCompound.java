package MTUI.Controls.Compound;

import MTUI.Controls.ICursorEvents;
import MTUI.Controls.IMTControl;
import MTUI.Controls.Compound.Component.AbstractCompoundComponent;

public interface IMTCompound extends IMTControl, ICursorEvents {

	void addControl(AbstractCompoundComponent control);
}
