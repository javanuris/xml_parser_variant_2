package parse;

import entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 23.02.2017.
 */
public class CoffeeDomParser extends CoffeeXmlValidate {

    public ArrayList<AbstractCoffe> parserCoffe() {
        if (!validatorXML()) {
            throw new RuntimeException(CoffeeXmlValidate.NOT_FOUND);
        }
        ArrayList<AbstractCoffe> coffeList = new ArrayList<>();
        Document coffeeDoc = getCoffeeFile();
        NodeList nodeList = coffeeDoc.getElementsByTagName("coffee");
        for (int pos = 0; pos < nodeList.getLength(); pos++) {
            Node current = nodeList.item(pos);
            coffeList.add(parseElement((Element) current));
        }
        return coffeList;
    }

    private Document getCoffeeFile() {
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.parse(CoffeeXmlValidate.XML_FILE);
            return doc;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AbstractCoffe parseElement(Element element) {
        AbstractCoffe abstractCoffe;
        switch (element.getAttribute("coffeekind")) {
            case "arabica":
                abstractCoffe = new ArabicaCoffee();
                getElements(element, abstractCoffe);
                return abstractCoffe;
            case "dewevrei":
                abstractCoffe = new DewevreiCoffe();
                getElements(element, abstractCoffe);
                return abstractCoffe;
            case "liberica":
                abstractCoffe = new LibericaCoffe();
                getElements(element, abstractCoffe);
                return abstractCoffe;
            case "canephore":
                abstractCoffe = new CanephoraCoffe();
                getElements(element, abstractCoffe);
                return abstractCoffe;
        }
        return null;
    }

    public void getElements(Element element, AbstractCoffe abstr) {
        Element coffeeType = (Element) element.getElementsByTagName("coffeetype").item(0);
        abstr.setCoffeeSort(coffeeType.getElementsByTagName("sort").item(0).getTextContent());
        abstr.setCoffeeType(coffeeType.getElementsByTagName("type").item(0).getTextContent());
        Element coffeeValue = (Element) element.getElementsByTagName("coffeevalue").item(0);
        abstr.setPrice(Integer.parseInt(coffeeValue.getElementsByTagName("price").item(0).getTextContent()));
        abstr.setWeight(Integer.parseInt(coffeeValue.getElementsByTagName("weight").item(0).getTextContent()));
    }
}

