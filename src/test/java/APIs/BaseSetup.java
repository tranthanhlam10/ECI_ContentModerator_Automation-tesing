package APIs;

import org.testng.annotations.BeforeClass;
import utils.PropertiesReader;
import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

public class BaseSetup {
    static Logger logger = Logger.getLogger("BaseSetup");

   @BeforeClass
    public static void setUp() throws IOException {

        String  env = (System.getProperty("env") == null) ? "dev" :System.getProperty("env");
        PropertiesReader reader = new PropertiesReader("src/test/resources/environments/"+env+"-env.properties");

        baseURI = reader.getProperty("uri");

        baseURI = "http://sl-api-eci-v1-20-0.datatrend.io";

        System.out.println(baseURI);

        logger.warning("BASE_URL in" + " "+ baseURI+ " " + "Environment has been created");

        logger.warning("BASE_URL in" + " "+ env+ " " + "Environment has been created");
        logger.warning("BASE_PATH "+" "+env+" "+"Environment has been already created");

   }
}
