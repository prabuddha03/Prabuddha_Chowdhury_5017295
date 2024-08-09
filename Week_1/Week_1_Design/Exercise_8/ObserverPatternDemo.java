import java.util.List;
import java.util.ArrayList;

public class ObserverPatternDemo {

    interface PriceTracker {
        void addListener(PriceListener listener);
        void removeListener(PriceListener listener);
        void notifyListeners();
    }

    static class CryptoMarket implements PriceTracker {
        private List<PriceListener> listeners;
        private String cryptoName;
        private double cryptoPrice;

        public CryptoMarket(String cryptoName, double cryptoPrice) {
            this.listeners = new ArrayList<>();
            this.cryptoName = cryptoName;
            this.cryptoPrice = cryptoPrice;
        }

        @Override
        public void addListener(PriceListener listener) {
            listeners.add(listener);
        }

        @Override
        public void removeListener(PriceListener listener) {
            listeners.remove(listener);
        }

        @Override
        public void notifyListeners() {
            for (PriceListener listener : listeners) {
                listener.update(cryptoName, cryptoPrice);
            }
        }

        public void setCryptoPrice(double cryptoPrice) {
            this.cryptoPrice = cryptoPrice;
            notifyListeners();
        }
    }

    interface PriceListener {
        void update(String cryptoName, double cryptoPrice);
    }

    static class MobileAlert implements PriceListener {
        private String alertName;

        public MobileAlert(String alertName) {
            this.alertName = alertName;
        }

        @Override
        public void update(String cryptoName, double cryptoPrice) {
            System.out.println(alertName + " received update: " + cryptoName + " is now " + cryptoPrice);
        }
    }

    static class WebAlert implements PriceListener {
        private String alertName;

        public WebAlert(String alertName) {
            this.alertName = alertName;
        }

        @Override
        public void update(String cryptoName, double cryptoPrice) {
            System.out.println(alertName + " received update: " + cryptoName + " is now " + cryptoPrice);
        }
    }

    public static void main(String[] args) {
        CryptoMarket cryptoMarket = new CryptoMarket("BTC", 30000.00);
    
        PriceListener mobileAlert = new MobileAlert("AndroidAlert");
        PriceListener webAlert = new WebAlert("BrowserAlert");
    
        cryptoMarket.addListener(mobileAlert);
        cryptoMarket.addListener(webAlert);
    
        cryptoMarket.setCryptoPrice(31000.00);
        cryptoMarket.setCryptoPrice(32000.00);
    
        cryptoMarket.removeListener(webAlert);
        cryptoMarket.setCryptoPrice(33000.00);
    }
}
