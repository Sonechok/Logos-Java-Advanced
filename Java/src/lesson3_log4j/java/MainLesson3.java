import org.apache.log4j.Logger;

public class MainLesson3 {
    private static final Logger LOG = Logger.getLogger(MainLesson3.class);

    public static void main(String[] args) {
        LOG.info("Program started");
        LOG.warn("Warn message");
        LOG.debug("Debug message");
        LOG.error("Error message");
    }

}
