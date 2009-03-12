package mtui.utils;

import java.util.Comparator;

import mtui.controls.IMTControl;


public class byInverseZIndex implements Comparator<IMTControl> {

	@Override
	public int compare(IMTControl c1, IMTControl c2) {
		return 0 - (c1.getZIndex()-c2.getZIndex());
	}

}
