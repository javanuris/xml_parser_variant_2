package parse;

import entity.*;
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
    private AbstractCoffe arabicaCoffee;
    private StringBuilder dataBuffer;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "coffee":
                switch (attributes.getValue(0).toString()) {
                    case "arabica":
                        arabicaCoffee = new ArabicaCoffee();
                        break;
                    case "dewevrei":
                        arabicaCoffee = new DewevreiCoffe();
                        break;
                    case "liberica":
                        arabicaCoffee = new LibericaCoffe();
                        break;
                    case "canephore":
                        arabicaCoffee = new CanephoraCoffe();
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
                arabicaCoffee.setCoffeeType(dataBuffer.toString());
                break;
            case "sort":
                arabicaCoffee.setCoffeeSort(dataBuffer.toString());
                break;
            case "price":
                arabicaCoffee.setPrice(Integer.parseInt(dataBuffer.toString()));
                break;
            case "weight":
                arabicaCoffee.setWeight(Integer.parseInt(dataBuffer.toString()));
                break;
            case "coffee":
                coffeeList.add(arabicaCoffee);
                break;
        }
    }

    public ArrayList<AbstractCoffe> parseCoffee() {
        if (!CoffeeParser.validatorXML()) {
            throw new RuntimeException(CoffeeParser.NOT_FOUND);
        }
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new CoffeeSaxParser();
            saxParser.parse(CoffeeParser.XML_FILE, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coffeeList;
    }
}
