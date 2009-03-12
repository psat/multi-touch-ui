package mtui.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import mtui.config.ConfigFile;
import mtui.constants.AppletConst;
import mtui.processing.ProcessingApplet;

/**
 * Class that implements ActionListener.
 * <p> Created to handle the events from the JMenuBar of The mtui.processing.ProcessingFrame
 * 
 * @author Nuno Santos
 *
 */

public class HandlerEventsMenuItem implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(((JMenuItem)e.getSource()).getText().equals(AppletConst.SUB_MENU_FILE_RESET)){
			ProcessingApplet.getInstance().Reset();
		}
		else if(((JMenuItem)e.getSource()).getText().equals(AppletConst.SUB_MENU_MEDIA_PICTURES)){
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int status = chooser.showOpenDialog(null);
	        if (status == JFileChooser.APPROVE_OPTION) {
	             File selectedFile = 
	                  chooser.getSelectedFile();
	             ConfigFile.setPicturesPath(selectedFile.getAbsolutePath());
	        }
	        
		}
		else if(((JMenuItem)e.getSource()).getText().equals(AppletConst.SUB_MENU_MEDIA_MOVIES)){
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int status = chooser.showOpenDialog(null);
	        if (status == JFileChooser.APPROVE_OPTION) {
	             File selectedFile = 
	                  chooser.getSelectedFile();
	             ConfigFile.setMoviesPath(selectedFile.getAbsolutePath());
	        }
	        
		}
	}

}
