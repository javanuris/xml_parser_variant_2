package parse;

import entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by User on 23.02.2017.
 */
public class CoffeeStaxParser extends CoffeeXmlValidate {

    private XMLStreamReader createCoffeeReader() {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader coffeeReader = factory.createXMLStreamReader(new FileInputStream(CoffeeXmlValidate.XML_FILE));
            return coffeeReader;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<AbstractCoffe> parseCoffee() {
        if (!validatorXML()) throw new RuntimeException(CoffeeXmlValidate.NOT_FOUND);
        XMLStreamReader coffeeReader = createCoffeeReader();

        ArrayList<AbstractCoffe> coffeeList = new ArrayList<>();
        AbstractCoffe abstractCoffee = new ArabicaCoffee();
        String data = "";
        try {
            while (coffeeReader.hasNext()) {
                int event = coffeeReader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (coffeeReader.getLocalName().equals("coffee")) {
                            switch (coffeeReader.getAttributeValue(0)) {
                                case "arabica":
                                    abstractCoffee = new ArabicaCoffee();
                                    break;
                                case "dewevrei":
                                    abstractCoffee = new DewevreiCoffe();
                                    break;
                                case "canephore":
                                    abstractCoffee = new CanephoraCoffe();
                                    break;
                                case "liberica":
                                    abstractCoffee = new LibericaCoffe();
                                    break;
                            }
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        data = coffeeReader.getText();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch (coffeeReader.getLocalName()) {
                            case "type":
                                abstractCoffee.setCoffeeType(data);
                                break;
                            case "sort":
                                abstractCoffee.setCoffeeSort(data);
                                break;
                            case "price":
                                abstractCoffee.setPrice(Integer.parseInt(data));
                                break;
                            case "weight":
                                abstractCoffee.setWeight(Integer.parseInt(data));
                                coffeeList.add(abstractCoffee);
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return coffeeList;
    }

}
