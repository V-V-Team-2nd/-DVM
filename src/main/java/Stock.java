import java.util.HashMap;
import java.util.Map;

class Stock {
    Map<Integer,Integer> stock = new HashMap<Integer,Integer>();
    Beverage[] ss = new Beverage[20];

    Stock(){
        ss[0] = new Beverage(1,"사이다",1000);
        for(int i=0;i<20;i++){
            stock.put(i,20-i);
            ss[i] = new Beverage(i,"사이다"+i,500*i);
        }
    }


    private int nowMenu;

    void checkPrice(int beverageID){
        ss[beverageID].getPrice();
    }
    void reduceStock(int beverageID){

    }
    void checkStock(){

    }
    void getStock(int beverageID){

    }
    void checkStockVerification(int beverageID){

    }
    void getBeverageName(int beverageID){

    }
    void updateStock(int beverageID){

    }

}
