import java.util.List;
import java.util.ArrayList;

public class ObserverPatternDemo {

    interface Sensor {
        void addObserver(Listener listener);

        void removeObserver(Listener listener);

        void notifyListeners();
    }

    static class WeatherStation implements Sensor {
        private List<Listener> listeners;
        private String location;
        private double temperature;

        public WeatherStation(String location, double temperature) {
            this.listeners = new ArrayList<>();
            this.location = location;
            this.temperature = temperature;
        }

        @Override
        public void addObserver(Listener listener) {
            listeners.add(listener);
        }

        @Override
        public void removeObserver(Listener listener) {
            listeners.remove(listener);
        }

        @Override
        public void notifyListeners() {
            for (Listener listener : listeners) {
                listener.update(location, temperature);
            }
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
            notifyListeners();
        }
    }

    interface Listener {
        void update(String location, double temperature);
    }

    static class MobileDevice implements Listener {
        private String deviceName;

        public MobileDevice(String deviceName) {
            this.deviceName = deviceName;
        }

        @Override
        public void update(String location, double temperature) {
            System.out.println(deviceName + " received update: Temperature at " + location + " is now " + temperature);
        }
    }

    static class WebApplication implements Listener {
        private String appName;

        public WebApplication(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(String location, double temperature) {
            System.out.println(appName + " received update: Temperature at " + location + " is now " + temperature);
        }
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation("New York", 75.0);

        Listener mobileDevice = new MobileDevice("iOSApp");
        Listener webApplication = new WebApplication("WeatherSite");

        weatherStation.addObserver(mobileDevice);
        weatherStation.addObserver(webApplication);

        weatherStation.setTemperature(78.5);
        weatherStation.setTemperature(80.0);

        weatherStation.removeObserver(webApplication);
        weatherStation.setTemperature(82.5);
    }
}
