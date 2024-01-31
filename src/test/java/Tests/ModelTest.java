package Tests;

import APIs.ModelAPIs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ModelTest {
    ModelAPIs modelAPIs = new ModelAPIs();

    @BeforeMethod
    public void setModelApis(){
        modelAPIs.setUpBasePath();
    }

    @Test
    public void getListModelDefault(){

        Response res = modelAPIs.getListModels();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 200);

    }

    @Test
    public void createModel(){

        Response res = modelAPIs.createModels();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }


    @Test
    public void updateModel(){
        Response res = modelAPIs.updateModel();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }

    @Test
    public void deleteModel(){
        Response res = modelAPIs.deleteModel();
        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }
}
