package Tests;

import APIs.BaseSetup;
import APIs.ModelAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;


public class ModelTest extends BaseSetup {
    ModelAPIs modelAPIs = new ModelAPIs();

    @BeforeTest
    public void setModelApis(){
        modelAPIs.setUpBasePath();
    }

    @Test
    public void getListModelDefault(){

        Response res = modelAPIs.getListModels();
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        // check by TestNG
        Assert.assertEquals(status_code, 200);


        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));


    }

    @Test
    public void createModel(){

        Response res = modelAPIs.createModels();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        JsonPath jsonPath = res.jsonPath();

        // check by TestNG
        Assert.assertEquals(status_code, 201);


        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten model duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

    }


    @Test
    public void updateModel(){
        Response res = modelAPIs.updateModel();
        res.prettyPrint();

        //JsonPath jsonPath = res.jsonPath();
        int status_code = res.statusCode();

        // check by TestNG
        Assert.assertEquals(status_code, 201);

        JsonPath jsonPath = res.jsonPath();

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten model duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

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
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten model duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("display_name"), is("Lam Test Autoamtion"));

    }
}
