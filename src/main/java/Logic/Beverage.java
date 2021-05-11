package Logic;

public class Beverage {
    /* Attributes */
    private int beverageID;
    private String name;
    private int price;

    /* Methods */
    public Beverage(int id, String name, int price){
        this.beverageID = id;
        this.name = name;
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
}
