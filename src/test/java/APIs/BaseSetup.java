package APIs;

import org.testng.annotations.BeforeSuite;
import utils.PropertiesReader;
import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;


public class BaseSetup {
    static Logger logger = Logger.getLogger("BaseSetup");

    // Dung ham static de set
    public static String getEnv(){
        return (System.getProperty("env") == null) ? "dev" :System.getProperty("env");
    }

    @BeforeSuite
    public static void setUp() throws IOException {

        String env = getEnv();

        baseURI = PropertiesReader.getProperty("src/test/resources/environments/" + env + "-env.properties", "uri");
        logger.warning("URI" + baseURI);
        logger.warning("BASE_URL in" + " "+ env+ " " + "Environment has been created");

    }



}
