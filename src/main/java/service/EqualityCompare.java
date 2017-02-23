package service;

import entity.AbstractCoffe;

import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public class EqualityCompare {

    public boolean equality(ArrayList<AbstractCoffe> obj1, ArrayList<AbstractCoffe> obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if ((obj1 == null && obj2 != null) || obj1 != null && obj2 == null || obj1.size() != obj2.size()) {
            return false;
        }
        obj1 = new ArrayList<>(obj1);
        obj2 = new ArrayList<>(obj2);
        return obj1.equals(obj2);
    }
}