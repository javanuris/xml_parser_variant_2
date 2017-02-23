package main;

import entity.AbstractCoffe;
import parse.CoffeeDomParser;
import parse.CoffeeSaxParser;
import parse.CoffeeStaxParser;
import service.EqualityCompare;
import ui.Shower;

import java.util.ArrayList;

/**
 * Created by User on 23.02.2017.
 */
public class Execute {

    public Execute() {

        ArrayList<AbstractCoffe> listSax = new CoffeeSaxParser().parseCoffee();
        ArrayList<AbstractCoffe> listStax = new CoffeeStaxParser().parseCoffee();
        ArrayList<AbstractCoffe> listDom = new CoffeeDomParser().parserCoffe();

        Shower shower = new Shower();

        EqualityCompare equality = new EqualityCompare();

        shower.showList(equality.equality(listSax , listStax));
        shower.showList(equality.equality(listSax , listDom));
        shower.showList(equality.equality(listDom , listStax));

        shower.showPopulate(listSax ,"SAX");
        shower.showPopulate(listDom ,"DOM");
        shower.showPopulate(listStax ,"STAX");
    }


}
