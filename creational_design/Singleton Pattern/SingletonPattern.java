// Singleton Logger Class
class Logger {
    private static Logger loggerInstance;

    private Logger() { }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

// Demo: Singleton Logger
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        System.out.println("Logger instances are the same: " + (logger1 == logger2));
    }
}
