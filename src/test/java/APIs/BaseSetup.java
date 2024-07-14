package APIs;

import org.testng.annotations.BeforeSuite;
import utils.PropertiesReader;
import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.baseURI;


public class BaseSetup {
    static Logger logger = Logger.getLogger("BaseSetup");

    @BeforeSuite
    public static void setUp() throws IOException {

        String  env = (System.getProperty("env") == null) ? "dev" :System.getProperty("env");
        PropertiesReader reader = new PropertiesReader("src/test/resources/environments/"+env+"-env.properties");

        baseURI = reader.getProperty("uri");


        logger.warning("BASE_URL in" + " "+ baseURI+ " " + "Environment has been created");
        logger.warning("BASE_URL in" + " "+ env+ " " + "Environment has been created");
        logger.warning("BASE_PATH "+" "+env+" "+"Environment has been already created");

    }


}
