package mtui.utils;

import java.util.Comparator;

import mtui.controls.IMTControl;

/**
 * 
 * Define condition when sorting collections in order.
 * Deepest objects come first
 * 
 * @author Nuno Santos
 *
 */
public class byZIndex implements Comparator<IMTControl>{

	@Override
	public int compare(IMTControl c1, IMTControl c2) {
		return  c1.getZIndex()-c2.getZIndex();
	}

}
