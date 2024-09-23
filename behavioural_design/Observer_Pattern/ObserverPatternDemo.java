import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer Interface
interface Observer {
    void update(float price);
}

// Concrete Observer
class StockDisplay implements Observer {
    private String stockName;

    public StockDisplay(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public void update(float price) {
        System.out.println("Stock: " + stockName + " is now $" + price);
    }
}

// Subject Class
class Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

// Demo: Stock Price Monitor
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Stock appleStock = new Stock();
        StockDisplay observer1 = new StockDisplay("Apple");
        StockDisplay observer2 = new StockDisplay("Google");

        appleStock.addObserver(observer1);
        appleStock.addObserver(observer2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new stock price: ");
        float newPrice = scanner.nextFloat();

        appleStock.setPrice(newPrice);  // Notify observers
    }
}
