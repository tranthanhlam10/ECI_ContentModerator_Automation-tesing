package Tests;

import APIs.ModelAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ModelTest {
    ModelAPIs modelAPIs = new ModelAPIs();

    @BeforeClass
    public void setModelApis(){
        modelAPIs.setUpURL();
    }

    @Test
    public void getListModelDefault(){

        Response res = modelAPIs.getListModels();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 401);

        // check by Hamcrest

        
        
    }
}
