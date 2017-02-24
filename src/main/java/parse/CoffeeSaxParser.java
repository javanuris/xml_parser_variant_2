package parse;

import entity.*;
import main.CaravanCoffee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 23.02.2017.
 */
public class CoffeeSaxParser extends DefaultHandler {

    private static ArrayList<AbstractCoffe> coffeeList = new ArrayList<>();
    private AbstractCoffe abstractCoffe;
    private StringBuilder dataBuffer;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "coffee":
                switch (attributes.getValue(0).toString()) {
                    case "arabica":
                        abstractCoffe = new ArabicaCoffee();
                        break;
                    case "dewevrei":
                        abstractCoffe = new DewevreiCoffe();
                        break;
                    case "liberica":
                        abstractCoffe = new LibericaCoffe();
                        break;
                    case "canephore":
                        abstractCoffe = new CanephoraCoffe();
                        break;
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        dataBuffer = new StringBuilder();
        dataBuffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "type":
                abstractCoffe.setCoffeeType(dataBuffer.toString());
                break;
            case "sort":
                abstractCoffe.setCoffeeSort(dataBuffer.toString());
                break;
            case "price":
                abstractCoffe.setPrice(Integer.parseInt(dataBuffer.toString()));
                break;
            case "weight":
                abstractCoffe.setWeight(Integer.parseInt(dataBuffer.toString()));
                break;
            case "coffee":
                coffeeList.add(abstractCoffe);
                break;
        }
    }

    public CaravanCoffee parseCoffee() {
        CaravanCoffee caravanCoffee = new CaravanCoffee();
        if (!CoffeeXmlValidate.validatorXML()) {
            throw new RuntimeException(CoffeeXmlValidate.NOT_FOUND);
        }
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new CoffeeSaxParser();
            saxParser.parse(CoffeeXmlValidate.XML_FILE, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        caravanCoffee.setAbstractCoffes(coffeeList);
        return caravanCoffee;
    }
}
