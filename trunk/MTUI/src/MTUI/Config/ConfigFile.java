package MTUI.Config;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

	private static Document document;
	public static String getPicturesPath(){
	
		Element picElement = getConfigElement(ConfigXML.PICTURES_ELEMENT);
		
		return picElement.getTextContent();
	}
	public static String getMoviesPath(){
		
		Element movElement = getConfigElement(ConfigXML.MOVIES_ELEMENT);
		
		return movElement.getTextContent();
	}
	public static void setPicturesPath(String strPicPath){
		Element picElement = getConfigElement(ConfigXML.PICTURES_ELEMENT);
		picElement.setTextContent(strPicPath);
		
		updateXMLFile(ConfigXML.PICTURES_ELEMENT, strPicPath);
	}
	public static void setMoviesPath(String strMovPath){
		
		updateXMLFile(ConfigXML.MOVIES_ELEMENT, strMovPath);
	}
	
	
	
	private static Element createConfigFile() throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		document = documentBuilder.newDocument();
		
		Element rootElement = document.createElement(ConfigXML.ROOT_ELEMENT);
		document.appendChild(rootElement);

		Element ePicturesPath = document.createElement(ConfigXML.PICTURES_ELEMENT);
		rootElement.appendChild(ePicturesPath);
		
		Element eMoviesPath = document.createElement(ConfigXML.MOVIES_ELEMENT);
		rootElement.appendChild(eMoviesPath);
		
		writeXMLFile();
        return rootElement;
	}
	
	private static void writeXMLFile(){

		try{
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(document);
	        StreamResult result =  new StreamResult(new File(ConfigXML.FILE_NAME));
	        transformer.transform(source, result);
		} catch(Exception ex){
			System.out.println("Cannot write on config file: " + ex.getMessage());
		}
	}
	
	private static Element readConfigFile() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        document = docBuilder.parse (new File(ConfigXML.FILE_NAME));

        // normalize text representation
        //doc.getDocumentElement ().normalize ();
        return document.getDocumentElement();
	}
	
	private static Element getConfigElement(String strElementName){
		Element root = getRootElement();
	
		return (Element) root.getElementsByTagName(strElementName).item(0);
	}
	private static Element getRootElement(){
		Element root = null;
		try{
			File cfg = new File(ConfigXML.FILE_NAME);
			if(!cfg.exists()){
				
				cfg.createNewFile();
				root = createConfigFile();
				
			} else {
			
				root = readConfigFile();
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return root;
	}
	
	private static void updateXMLFile(String strElementName, String strTextContent){
		Element elm = getConfigElement(strElementName);
		elm.setTextContent(strTextContent);
		
		writeXMLFile();
	}
}
