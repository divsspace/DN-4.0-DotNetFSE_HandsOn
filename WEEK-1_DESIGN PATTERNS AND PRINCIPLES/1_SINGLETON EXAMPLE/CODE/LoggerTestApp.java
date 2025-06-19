public class LoggerTestApp {
    public static void main(String[] args) {
        LoggerService ref1 = LoggerService.fetchInstance();
        LoggerService ref2 = LoggerService.fetchInstance();

        ref1.writeLog("Startup complete.");
        ref2.writeLog("Running diagnostics...");

        System.out.println(">> Are both logger references the same object? " + (ref1 == ref2));

        Runnable logTask = () -> {
            LoggerService threadLogger = LoggerService.fetchInstance();
            threadLogger.writeLog("Log from " + Thread.currentThread().getName());
        };

        Thread threadOne = new Thread(logTask, "Worker-1");
        Thread threadTwo = new Thread(logTask, "Worker-2");

        threadOne.start();
        threadTwo.start();
    }
}
