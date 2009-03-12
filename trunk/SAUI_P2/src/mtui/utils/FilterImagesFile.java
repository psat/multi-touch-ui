package mtui.utils;

import java.io.File;
import java.io.FilenameFilter;
/**
 * Used to filter files in order to obtain only images
 * 
 * @author Nuno Santos
 *
 */
public class FilterImagesFile implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		
		if(name.indexOf(".jpg")!=-1 || name.indexOf(".gif")!=-1){
			return true;
		}
		else return false;
	}

}
