package Tests;

import APIs.ProductLineAPIs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductLineTest {
    ProductLineAPIs productLineAPIs = new ProductLineAPIs();

    @BeforeMethod
    public void setProductLineApis(){
        productLineAPIs.setUpBasePath();
    }

    @Test
    public void getListProductLineDefault(){

        Response res = productLineAPIs.getListProductLine();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 200);

    }
    @Test
    public void createProductLine(){

        Response res = productLineAPIs.createProductLines();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }

    @Test
    public void updateProductLine(){

        Response res = productLineAPIs.updateProductLines();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }

    @Test
    public void deleteProductLine(){

        Response res = productLineAPIs.deleteProductLine();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }
}
