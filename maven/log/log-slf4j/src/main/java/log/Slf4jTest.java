package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    public static void main(String[] args) {
        logger.trace("simple TRACE test");
        logger.debug("simple DEBUG test");
        logger.info("simple {} test", "INFO");
        logger.warn("simple {} {}","WARN","test");
        logger.error("simple ERROR test");
    }
}
