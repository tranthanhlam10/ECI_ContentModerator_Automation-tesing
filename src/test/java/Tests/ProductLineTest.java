package Tests;

import APIs.BaseSetup;
import APIs.ProductLineAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;


public class ProductLineTest extends BaseSetup {
    ProductLineAPIs productLineAPIs = new ProductLineAPIs();

    final String GET_LIST_PRODUCT_LINE_SCHEMA = "Schema/Product Line/get_list_product_line_schema.json";
    final String CREATE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/create_product_line_schema.json";
    final String UPDATE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/update_product_line_schema.json";
    final String DELETE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/delete_product_line_schema.json";

    @BeforeTest
    public void setProductLineApis(){
        productLineAPIs.setUpBasePath();
    }

    @Test
    public void getListProductLineDefault(){

        Response res = productLineAPIs.getListProductLine();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_PRODUCT_LINE_SCHEMA));

    }
    @Test
    public void createProductLine(){

        Response res = productLineAPIs.createProductLines();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_PRODUCT_LINE_SCHEMA));

    }

    @Test
    public void updateProductLine(){

        Response res = productLineAPIs.updateProductLines();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_PRODUCT_LINE_SCHEMA));



    }

    @Test
    public void deleteProductLine(){

        Response res = productLineAPIs.deleteProductLine();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_PRODUCT_LINE_SCHEMA));

    }
}
