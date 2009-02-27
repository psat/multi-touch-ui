package MTUI.Utils;

import java.util.Comparator;

import MTUI.Controls.IMTControl;

public class byInverseZIndex implements Comparator<IMTControl> {

	@Override
	public int compare(IMTControl c1, IMTControl c2) {
		return 0 - (c1.getZIndex()-c2.getZIndex());
	}

}
