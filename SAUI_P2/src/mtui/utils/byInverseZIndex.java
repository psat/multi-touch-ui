package mtui.utils;

import java.util.Comparator;

import mtui.controls.IMTControl;

/**
 * 
 * Define condition when sorting collections in order.
 * Deepest objects come at last
 * 
 * @author Nuno Santos
 *
 */
public class byInverseZIndex implements Comparator<IMTControl> {

	@Override
	public int compare(IMTControl c1, IMTControl c2) {
		return 0 - (c1.getZIndex()-c2.getZIndex());
	}

}
