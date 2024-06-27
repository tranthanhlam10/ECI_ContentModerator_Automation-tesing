package Tests;

import APIs.AuthencationAPIs;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonFileReader;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthencationTest {
    AuthencationAPIs authencationAPIs = new APIs.AuthencationAPIs();
    JsonFileReader jsonFileReader = new JsonFileReader();

    @BeforeMethod
    public void setBrandApis(){
        authencationAPIs.setUpBasePath();
    }

//    @Test
//    public void getListBrandDefault() throws IOException {
//
//        Response res = authencationAPIs.getToken();
//        res.prettyPrint();
//
//
//        //JsonPath jsonPath = res.jsonPath();
//        int status_code = res.statusCode();
//        String content_type = res.contentType();
//
//        // check Json Schema by Json Validator
////        assert get_list_brand_schema != null;
//        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileReader.JsonFileReader(GET_LIST_BRAND_SCHEMA)));
//        // check data response by Hamcrest
//        assertThat(status_code, is(200));
//        assertThat(content_type, is("application/json"));
//
//    }
}
