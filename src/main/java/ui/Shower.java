package ui;

import entity.AbstractCoffe;

import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public class Shower {
    private static final String COFFE_PARSING_NAME_TEXT ="Parsing name: ->> ";

    public void showPopulateObjects(ArrayList<AbstractCoffe> abstractCoffes , String parsingName){
        System.out.println( COFFE_PARSING_NAME_TEXT+ parsingName.toUpperCase());
        ArrayList<AbstractCoffe> list = abstractCoffes;
        for(AbstractCoffe abst : abstractCoffes){
            System.out.println("----------------------------");
            System.out.println(abst);
        }
        System.out.println("--------------------------- \n\n");
    }

}
