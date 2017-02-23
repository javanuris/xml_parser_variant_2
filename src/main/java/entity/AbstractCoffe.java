package entity;

/**
 * Created by User on 20.02.2017.
 */
public abstract class AbstractCoffe {
    private String coffeeType;
    private String coffeeSort;
    private int price;
    private int weight;

    private static final String COFFE_TYPE_TEXT = "ТИП: ";
    private static final String COFFE_SORT_TEXT = " | СОРТ: ";
    private static final String COFFE_PRICE_TEXT = " | ЦЕНА: ";
    private static final String COFFE_WEIGHT_TEXT = " | ВEC: ";
    private static final String COFFE_KIND_TEXT = " | ВИД: ";

    public AbstractCoffe(String coffeeType, String coffeeSort) {
        this.coffeeType = coffeeType;
        this.coffeeSort = coffeeSort;
    }

AbstractCoffe(){

}
    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCoffeeSort() {
        return coffeeSort;
    }

    public void setCoffeeSort(String coffeeSort) {
        this.coffeeSort = coffeeSort;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCoffe that = (AbstractCoffe) o;

        if (price != that.price) return false;
        if (weight != that.weight) return false;
        if (coffeeType != null ? !coffeeType.equals(that.coffeeType) : that.coffeeType != null) return false;
        return coffeeSort != null ? coffeeSort.equals(that.coffeeSort) : that.coffeeSort == null;

    }

    @Override
    public int hashCode() {
        int result = coffeeType != null ? coffeeType.hashCode() : 0;
        result = 31 * result + (coffeeSort != null ? coffeeSort.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return COFFE_TYPE_TEXT+coffeeType
                +COFFE_SORT_TEXT+coffeeSort
                +COFFE_PRICE_TEXT+ price
                +COFFE_WEIGHT_TEXT+weight
                +COFFE_KIND_TEXT+getClass().getSimpleName();
    }
}
