package Tests;

import APIs.BaseSetup;
import APIs.ProductLineAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;


public class ProductLineTest extends BaseSetup {
    ProductLineAPIs productLineAPIs = new ProductLineAPIs();

    @BeforeTest
    public void setProductLineApis(){
        productLineAPIs.setUpBasePath();
    }

    @Test
    public void getListProductLineDefault(){

        Response res = productLineAPIs.getListProductLine();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();
        JsonPath jsonPath = res.jsonPath();

        // check by TestNG
        Assert.assertEquals(status_code, 200);

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));

    }
    @Test
    public void createProductLine(){

        Response res = productLineAPIs.createProductLines();
        res.prettyPrint();

        int status_code = res.statusCode();

        JsonPath jsonPath = res.jsonPath();

        // check by TestNG
        Assert.assertEquals(status_code, 201);

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten product line duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

    }

    @Test
    public void updateProductLine(){

        Response res = productLineAPIs.updateProductLines();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        JsonPath jsonPath = res.jsonPath();

        // check by TestNG
        Assert.assertEquals(status_code, 201);

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten product line duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

    }

    @Test
    public void deleteProductLine(){

        Response res = productLineAPIs.deleteProductLine();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        JsonPath jsonPath = res.jsonPath();

        // check by TestNG
        Assert.assertEquals(status_code, 201);

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten product line duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

    }
}
