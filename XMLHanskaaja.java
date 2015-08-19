import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLHanskaaja {
	public static void main(String[] args) throws ParserConfigurationException {
		// Avaa file
		File file = new File("text.xml");
		
		// Tee DocBuild
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = null;
		
		// Try catch
		try {
			// Parse
			doc = db.parse(file);
		// SAX ja IO except
		} catch(SAXException se) {
			se.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// KÄsittele file Nodena (NodeList)
		doc.getDocumentElement().normalize();
		System.out.println("Juurielementti: " + doc.getDocumentElement().getNodeName());
		NodeList nl = doc.getElementsByTagName("card");
		System.out.println("-------");
				
		// Printtaa loopissa elementit
		for(int tmp = 0; tmp < nl.getLength(); tmp++) {
			Node n = nl.item(tmp);
			System.out.println("\nNykyinen: " + n.getNodeName());
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				Element el = (Element) n;
				System.out.println("Title: " + el.getElementsByTagName("title").item(0).getTextContent());
			}
		}
	}
}