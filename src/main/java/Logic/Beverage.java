package Logic;

public class Beverage {
    /* Attributes */
    private char beverageID;
    private char[] name = new char[13];
    private int price;

    /* Methods */
    public int getPrice(){
        return this.price;
    }
    public char[] getName(){
        return this.name;
    }
}
