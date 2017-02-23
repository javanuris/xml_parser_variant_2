package parse;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 23.02.2017.
 */

public abstract class CoffeeParser {
    public static final String XML_FILE = "src/main/resources/coffee.xml";
    public static final String XSD_FILE = "src/main/resources/temple.xsd";
    public static final String NOT_FOUND = "Some problem with XML file";

    public static boolean validatorXML() {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSD_FILE));
            Validator valid = schema.newValidator();
            valid.validate(new StreamSource(new File(XML_FILE)));
        } catch (IOException | SAXException e) {
            System.out.println(NOT_FOUND + e.getMessage());
            return false;
        }
        return true;
    }

}
