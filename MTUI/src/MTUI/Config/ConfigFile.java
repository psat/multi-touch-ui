package MTUI.Config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import MTUI.Constants.ConfigXML;

public class ConfigFile {

	public static String getPicturesPath(){
	
		String strPicPath = "";
		File cfg = new File(ConfigXML.FILE_NAME);
		if(!cfg.exists()){
			try{
				cfg.createNewFile();
				createConfigFile(cfg);
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		return strPicPath;
	}
	public static String getMoviesPath(){
		String strMovPath = "";
		File cfg = new File(ConfigXML.FILE_NAME);
		if(!cfg.exists()){
			try{
				cfg.createNewFile();
				createConfigFile(cfg);
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		} else {
			try{
				Element root = readConfigFile(cfg);
				for(Node node : root.getChildNodes()){
					
				}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			
		}
		return strMovPath;
	}
	public static void setPicturesPath(){
		
	}
	public static void setMoviesPath(){
		
	}
	
	
	
	private static void createConfigFile(File cfg) throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.newDocument();
		
		Element rootElement = document.createElement(ConfigXML.ROOT_ELEMENT);
		document.appendChild(rootElement);

		Element ePicturesPath = document.createElement(ConfigXML.PICTURES_ELEMENT);
		rootElement.appendChild(ePicturesPath);
		
		Element eMoviesPath = document.createElement(ConfigXML.MOVIES_ELEMENT);
		rootElement.appendChild(eMoviesPath);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result =  new StreamResult(cfg);
        transformer.transform(source, result);
	}
	
	private static Element readConfigFile(File cfg) throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (cfg);

        // normalize text representation
        //doc.getDocumentElement ().normalize ();
        return doc.getDocumentElement();
	}
}
