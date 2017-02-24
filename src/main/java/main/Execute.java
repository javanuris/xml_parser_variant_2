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

        CaravanCoffee listSax = new CoffeeSaxParser().parseCoffee();
        CaravanCoffee listStax = new CoffeeStaxParser().parseCoffee();
        CaravanCoffee listDom = new CoffeeDomParser().parserCoffe();

        System.out.println(listSax.equals(listDom));
        System.out.println(listStax.equals(listDom));
       // Shower shower = new Shower();

        //EqualityCompare equality = new EqualityCompare();

       // shower.showList(equality.equality(listSax , listStax));
       // shower.showList(equality.equality(listSax , listDom));
      //  shower.showList(equality.equality(listDom , listStax));

       // shower.showPopulate(listSax ,"SAX");
       // shower.showPopulate(listDom ,"DOM");
       // shower.showPopulate(listStax ,"STAX");
    }


}
