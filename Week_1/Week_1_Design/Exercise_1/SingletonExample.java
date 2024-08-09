package Example1;

public class SingletonExample {

    public static class LogManager {
        private static volatile LogManager logManagerInstance = null;

        private LogManager() {
        }

        public static LogManager getLogManagerInstance() {
            if (logManagerInstance == null) {
                synchronized (LogManager.class) {
                    if (logManagerInstance == null) {
                        logManagerInstance = new LogManager();
                    }
                }
            }
            return logManagerInstance;
        }

        public void writeLog(String logMessage) {
            System.out.println("Log: " + logMessage);
        }
    }

    public static void main(String[] args) {
        LogManager log1 = LogManager.getLogManagerInstance();
        LogManager log2 = LogManager.getLogManagerInstance();

        log1.writeLog("First log entry.");
        log2.writeLog("Second log entry.");
        log1.writeLog("Third log entry.");

        if (log1 == log2) {
            System.out.println("log1 and log2 refer to the same instance.");
        } else {
            System.out.println("log1 and log2 refer to different instances.");
        }
    }
}
