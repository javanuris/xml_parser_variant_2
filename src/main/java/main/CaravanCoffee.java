package main;

import entity.AbstractCoffe;

import java.util.ArrayList;

/**
 * Created by User on 24.02.2017.
 */
public class CaravanCoffee {

  private ArrayList<AbstractCoffe> abstractCoffes = new ArrayList<>();

    public void setAbstractCoffes(ArrayList<AbstractCoffe> abstractCoffes) {
        this.abstractCoffes = abstractCoffes;
    }

    public ArrayList<AbstractCoffe> getAbstractCoffes() {
        return abstractCoffes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaravanCoffee that = (CaravanCoffee) o;

        return abstractCoffes != null ? abstractCoffes.equals(that.abstractCoffes) : that.abstractCoffes == null;

    }

    @Override
    public int hashCode() {
        return abstractCoffes != null ? abstractCoffes.hashCode() : 0;
    }
}
