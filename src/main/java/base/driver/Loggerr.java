package base.driver;

import org.apache.http.NameValuePair;
import org.apache.log4j.Logger;

public class Loggerr {
    final static Logger logger = Logger.getLogger(Loggerr.class);

    public Logger getLogger() {
        return logger;
    }

    public static void log(String info) {
        logger.info(info);
    }

    public static void logPOSTBody(NameValuePair[] body) {
        log("BODY");
        for (NameValuePair string : body) {
            log(string.getName() + " : " + string.getValue());
        }
    }
}
