class Beverage {
    private int beverageID;
    private String name;
    private int price;

    public Beverage(int beverageID , String name , int price) {
        this.beverageID = beverageID;
        this.name = name;
        this.price = price;

    }

    public int getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

}