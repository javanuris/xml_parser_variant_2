package main;


import parse.CoffeeDomParser;
import parse.CoffeeSaxParser;
import parse.CoffeeStaxParser;
import ui.Shower;

/**
 * Created by User on 23.02.2017.
 */
public class Execute {

    public Execute() {

        CaravanCoffee listSax = new CoffeeSaxParser().parseCoffee();
        CaravanCoffee listStax = new CoffeeStaxParser().parseCoffee();
        CaravanCoffee listDom = new CoffeeDomParser().parserCoffe();
        System.out.println(listSax.equals(listDom));
        System.out.println(listDom.equals(listStax));
        System.out.println(listSax.equals(listStax));

        Shower shower = new Shower();

        shower.showPopulate(listSax.getAbstractCoffes() ,"Sax");
        shower.showPopulate(listDom.getAbstractCoffes() ,"Dom");
        shower.showPopulate(listStax.getAbstractCoffes() ,"Stax");
    }


}
