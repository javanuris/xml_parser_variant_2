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

        EqualityCompare equalityCompare = new EqualityCompare();

        System.out.println(equalityCompare.equality(listSax , listStax));
        System.out.println(equalityCompare.equality(listSax , listDom));
        System.out.println(equalityCompare.equality(listDom , listStax));

      shower.showPopulateObjects(listSax ,"SAX");
    }


}
