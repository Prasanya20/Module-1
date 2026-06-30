import java.util.ArrayList;

interface Observer {
    void update(double price);
}

interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private ArrayList<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    public void setStockPrice(double price) {
        this.stockPrice = price;
        System.out.println("\nStock Price Changed to: Rs." + price);
        notifyObservers();
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: Stock price updated to Rs." + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: Stock price updated to Rs." + price);
    }
}

public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice(1500);
        stockMarket.setStockPrice(1800);

        stockMarket.removeObserver(mobile);

        stockMarket.setStockPrice(2000);
    }
}
