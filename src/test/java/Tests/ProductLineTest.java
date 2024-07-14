package Tests;

import APIs.BaseSetup;
import APIs.ProductLineAPIs;
import ObjectResponse.ModelResponse;
import ObjectResponse.ProductLineResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ProductLineTest extends BaseSetup {
    ProductLineAPIs productLineAPIs = new ProductLineAPIs();

    final String GET_LIST_PRODUCT_LINE_SCHEMA = "Schema/Product Line/get_list_product_line_schema.json";
    final String CREATE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/create_product_line_schema.json";
    final String UPDATE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/update_product_line_schema.json";
    final String DELETE_PRODUCT_LINE_SCHEMA = "Schema/Product Line/delete_product_line_schema.json";

    private int product_line_id;

    @BeforeMethod
    public void setProductLineApis(){
        productLineAPIs.setUpBasePath();
    }

    @Test
    public void getListProductLineDefaultValidation(){

        Response res = productLineAPIs.getListProductLineValidation();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_PRODUCT_LINE_SCHEMA));

    }
    @Test
    public void createProductLineValidation(){

        Response res = productLineAPIs.createProductLinesValidation();
        res.prettyPrint();

        ProductLineResponse productlineRes = res.jsonPath().getObject("", ProductLineResponse.class);
        product_line_id = productlineRes.getId();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_PRODUCT_LINE_SCHEMA));

    }

    @Test
    public void updateProductLineValidation(){

        Response res = productLineAPIs.updateProductLinesValidation(product_line_id);
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_PRODUCT_LINE_SCHEMA));



    }

    @Test
    public void deleteProductLineValidation(){

        Response res = productLineAPIs.deleteProductLineValidation(product_line_id);
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_PRODUCT_LINE_SCHEMA));

    }
}
