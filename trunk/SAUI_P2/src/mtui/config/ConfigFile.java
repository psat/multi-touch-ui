package mtui.config;

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

import mtui.constants.ConfigXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *Class that handles configuration files.
 *<p>
 *The configuration file is stored on the root path in the XML file "cfg.xml" and holds the path of media.
 *<p>
 *User can change the display media by changing the path.
 * 
 * @author Nuno Santos
 *
 */
public class ConfigFile {

	private static Document document;
	
	/**
	 * This will give the pictures path stored on the configuration file 
	 * 
	 * @return (String)  pictures path
	 */
	public static String getPicturesPath(){
	
		Element picElement = getConfigElement(ConfigXML.PICTURES_ELEMENT);
		
		return picElement.getTextContent();
	}
	/**
	 * This will give the movies path stored on the configuration file 
	 * 
	 * @return (String) movies path
	 */
	public static String getMoviesPath(){
		
		Element movElement = getConfigElement(ConfigXML.MOVIES_ELEMENT);
		
		return movElement.getTextContent();
	}
	/**
	 * Change the pictures path on configuration file
	 * 
	 * @param strPicPath (String)
	 */
	public static void setPicturesPath(String strPicPath){
		Element picElement = getConfigElement(ConfigXML.PICTURES_ELEMENT);
		picElement.setTextContent(strPicPath);
		
		updateXMLFile(ConfigXML.PICTURES_ELEMENT, strPicPath);
	}
	/**
	 * Change the movies path on configuration file
	 * 
	 * @param strNoviesPath (String)
	 */
	public static void setMoviesPath(String strMovPath){
		
		updateXMLFile(ConfigXML.MOVIES_ELEMENT, strMovPath);
	}
	
	
	/**
	 * When configuration file doesn't exist this function is called in order to create the "cfg.xml"
	 * <p>
	 * @return (Element) XML root element allowing further changes/reading at nodes of the XML after the document created.
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
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
	/**
	 * Writes the root element and childs to the configuration file.
	 */
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

	/**
	 * Obtain XML elements from the configuration file.
	 * @return (Element) Root element
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static Element readConfigFile() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        document = docBuilder.parse (new File(ConfigXML.FILE_NAME));

        // normalize text representation
        //doc.getDocumentElement ().normalize ();
        return document.getDocumentElement();
	}
	
	/**
	 * Search a specific element of the root child list
	 * 
	 * @param strElementName (String) The tag name of the element
	 * @return (Element) 
	 */
	private static Element getConfigElement(String strElementName){
		Element root = getRootElement();
	
		return (Element) root.getElementsByTagName(strElementName).item(0);
	}
	/**
	 * Read the configuration file and get root element
	 * @return (Element) root element
	 */
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
	/**
	 * Change the content of an element and then write to configuration file
	 * @param strElementName (String) Tag name of the element
	 * @param strTextContent (String) Value to be changed to
	 */
	private static void updateXMLFile(String strElementName, String strTextContent){
		Element elm = getConfigElement(strElementName);
		elm.setTextContent(strTextContent);
		
		writeXMLFile();
	}
}
