package selen;

import org.apache.log4j.Logger;

public class Loggerr {

    final static Logger logger = Logger.getLogger(Loggerr.class);

    public Logger getLogger() {
        return logger;
    }

    public static void log(String info) {
        logger.info(info);
    }
}