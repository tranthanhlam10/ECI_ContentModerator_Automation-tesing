package Tests;

import APIs.BaseSetup;
import APIs.ModelAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;


public class ModelTest extends BaseSetup {
    ModelAPIs modelAPIs = new ModelAPIs();

    final String GET_LIST_MODEL_SCHEMA = "Schema/Brand/get_list_brand_schema.json";
    final String CREATE_MODEL_SCHEMA = "Schema/Brand/create_brand_schema.json";
    final String UPDATE_MODEL_SCHEMA = "Schema/Brand/update_brand_schema.json";
    final String DELETE_MODEL_SCHEMA = "Schema/Brand/delete_brand_schema.json";

    @BeforeTest
    public void setModelApis(){
        modelAPIs.setUpBasePath();
    }

    @Test
    public void getListModelDefault(){

        Response res = modelAPIs.getListModels();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_MODEL_SCHEMA));

    }

    @Test
    public void createModel(){

        Response res = modelAPIs.createModels();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_MODEL_SCHEMA));

    }


    @Test
    public void updateModel(){
        Response res = modelAPIs.updateModel();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_MODEL_SCHEMA));

    }

    @Test
    public void deleteModel(){
        Response res = modelAPIs.deleteModel();
        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        // check by TestNG
        Assert.assertEquals(status_code, 201);


        JsonPath jsonPath = res.jsonPath();

        // Check null response
        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_MODEL_SCHEMA));

    }
}
