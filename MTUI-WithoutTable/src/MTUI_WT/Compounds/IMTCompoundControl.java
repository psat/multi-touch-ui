package MTUI_WT.Compounds;
import MTUI_WT.Compounds.Component.AbstractCompoundComponent;
import MTUI_WT.Controls.*;

public interface IMTCompoundControl extends IMTControl {

	void addControl(AbstractCompoundComponent control);
	void removeControl(AbstractCompoundComponent control);
}
