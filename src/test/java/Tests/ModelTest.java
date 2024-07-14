package Tests;

import APIs.BaseSetup;
import APIs.ModelAPIs;
import ObjectResponse.BrandResponse;
import ObjectResponse.ModelResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class ModelTest extends BaseSetup {

    ModelAPIs modelAPIs = new ModelAPIs();

    final String GET_LIST_MODEL_SCHEMA = "Schema/Brand/get_list_brand_schema.json";
    final String CREATE_MODEL_SCHEMA = "Schema/Brand/create_brand_schema.json";
    final String UPDATE_MODEL_SCHEMA = "Schema/Brand/update_brand_schema.json";
    final String DELETE_MODEL_SCHEMA = "Schema/Brand/delete_brand_schema.json";

    private int model_id;

    @BeforeMethod
    public void setModelApis(){
        modelAPIs.setUpBasePath();
    }

    @Test
    public void getListModelDefaultValidation(){

        Response res = modelAPIs.getListModelsValidation();
        res.prettyPrint();
        ModelResponse modelRes = res.jsonPath().getObject("", ModelResponse.class);
        model_id = modelRes.getId();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_MODEL_SCHEMA));

    }

    @Test
    public void createModelValidation(){

        Response res = modelAPIs.createModelsValidation();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_MODEL_SCHEMA));

    }


    @Test
    public void updateModelValidation(){
        Response res = modelAPIs.updateModelValidation(model_id);
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_MODEL_SCHEMA));

    }

    @Test
    public void deleteModelValidation(){
        Response res = modelAPIs.deleteModelValidation(model_id);
        int status_code = res.statusCode();

        // Check null response
        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_MODEL_SCHEMA));

    }
}
