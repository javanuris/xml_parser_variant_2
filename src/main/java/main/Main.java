package main;

import entity.AbstractCoffe;
import parse.CoffeeDomParser;
import parse.CoffeeParser;

import java.util.ArrayList;

/**
 * Created by User on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        CoffeeDomParser coffeeDomParser = new CoffeeDomParser();
        ArrayList<AbstractCoffe>list =coffeeDomParser.parserCoffe();
        System.out.println(list);
    }
}
