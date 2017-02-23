package parse;

import entity.AbstractCoffe;
import entity.ArabicaCoffee;
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

    private ArrayList<AbstractCoffe> coffeeList;
    private ArabicaCoffee arabicaCoffee;
    private StringBuilder dataBuffer;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "coffee":
                arabicaCoffee = new ArabicaCoffee();
                break;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "coffee":
                coffeeList.add(arabicaCoffee);
                break;
            case "":
        }
    }

    public ArrayList<AbstractCoffe> parseCoffee() {
        if (!CoffeeParser.validateXML()) {
            throw new RuntimeException("Some problem with XML file");
        }
        coffeeList = new ArrayList<>();
        String path = "src/main/resources/coffee.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new CoffeeSaxParser();
            saxParser.parse(path, handler);


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
