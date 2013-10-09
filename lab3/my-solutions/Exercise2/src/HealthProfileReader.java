
/**
 *
 * @author Matteo Matassoni
 */
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class HealthProfileReader {
	static Document doc;
    static XPath xpath;
	
	static {        
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            
            doc = builder.parse("people.xml");
            
            //creating xpath object
            XPathFactory factory = XPathFactory.newInstance();
            xpath = factory.newXPath();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
	}
	
	public String getHealthProfile(String firstname, String lastname) throws XPathExpressionException
	{
    	System.out.println("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile");
	    XPathExpression expr = xpath.compile("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node.getTextContent();
	}
	
	public double getWeight(String firstname, String lastname) throws XPathExpressionException
	{
	    System.out.println("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile/weight");
	    XPathExpression expr = xpath.compile("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile/weight");
        Double weight = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
        return weight;
	}
	
	public double getHeight(String firstname, String lastname) throws XPathExpressionException
	{
    	System.out.println("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile/height");
	    XPathExpression expr = xpath.compile("/people/person[firstname='" + firstname + "' and lastname='" + lastname +"']/healthprofile/height");
        Double height = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
        return height;
	}
	
	public double getBMI(String firstname, String lastname) throws XPathExpressionException
	{
	    double weight = getWeight(firstname, lastname);
	    double height = getHeight(firstname, lastname);
	    return weight / (height * height);
	}
}
