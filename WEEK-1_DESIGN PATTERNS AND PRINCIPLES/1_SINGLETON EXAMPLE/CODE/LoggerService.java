public class LoggerService {
    private static volatile LoggerService uniqueLogger;

    private LoggerService() {
        System.out.println(">>> LoggerService instance created.");
    }

    public static LoggerService fetchInstance() {
        if (uniqueLogger == null) {
            synchronized (LoggerService.class) {
                if (uniqueLogger == null) {
                    uniqueLogger = new LoggerService();
                }
            }
        }
        return uniqueLogger;
    }

    // Logging method
    public void writeLog(String msg) {
        System.out.printf("-- [%s] :: %s%n", Thread.currentThread().getName(), msg);
    }
}
