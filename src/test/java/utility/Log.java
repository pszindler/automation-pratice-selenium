package utility;

import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void startTestCase(TestInfo testInfo) {
        logger.info("test started: " + testInfo.getDisplayName());
    }

    public static void endTestCase(TestInfo testInfo) {
        logger.info("test ended: " + testInfo.getDisplayName()
                + " with tags: " + testInfo.getTags());
    }

    public static void classThreadDebug(Object obj) {
        logger.debug(obj.getClass().getName() + " initialized with thread: " + Thread.currentThread().getName());
    }

    public static void seleniumThreadExitDebug() {
        logger.debug("Selenium Web driver successfully closed on thread: " + Thread.currentThread().getName());
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }


}