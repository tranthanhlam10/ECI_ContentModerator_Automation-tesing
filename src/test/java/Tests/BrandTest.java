package Tests;

import APIs.BrandAPIs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrandTest {
    BrandAPIs brandAPIs = new BrandAPIs();

    @BeforeMethod
    public void setBrandApis(){
       brandAPIs.setUpBasePath();
    }

    @Test
    public void getListBrandDefault(){

        Response res = brandAPIs.getListBrands();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 200);

    }
    @Test
    public void createBrand(){

        Response res = brandAPIs.createBrands();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

        // check by Hamcrest


    }

    @Test
    public void updateBrand(){

        Response res = brandAPIs.updateBrand();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }

    @Test
    public void deleteBrand(){

        Response res = brandAPIs.deleteBrand();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int statuscode = res.statusCode();

        // check by TestNG
        Assert.assertEquals(statuscode, 201);

    }

}
