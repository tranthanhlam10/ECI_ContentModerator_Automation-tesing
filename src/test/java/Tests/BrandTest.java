package Tests;

import APIs.BaseSetup;
import APIs.BrandAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class BrandTest extends BaseSetup {
    BrandAPIs brandAPIs = new BrandAPIs();
    final String GET_LIST_BRAND_SCHEMA = "Schema/Brand/get_list_brand_schema.json";
    final String CREATE_BRAND_SCHEMA = "Schema/Brand/create_brand_schema.json";
    final String UPDATE_BRAND_SCHEMA = "Schema/Brand/update_brand_schema.json";
    final String DELETE_BRAND_SCHEMA = "Schema/Brand/delete_brand_schema.json";

    @BeforeTest
    public void setBrandApis(){
       brandAPIs.setUpBasePath();
    }

    @Test
    public void getListBrandDefault() throws IOException {

        Response res = brandAPIs.getListBrands();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_BRAND_SCHEMA));
    }
    //@Test(dataProvider = "excelData_Brand", dataProviderClass = ExcelReader.class)
    @Test
    public void createBrand(){

        Response res = brandAPIs.createBrands();
        res.prettyPrint();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_BRAND_SCHEMA));

    }

    @Test
    public void updateBrand(){

        Response res = brandAPIs.updateBrand();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_BRAND_SCHEMA));

    }

    @Test
    public void deleteBrand() {

        Response res = brandAPIs.deleteBrand();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_BRAND_SCHEMA));
    }

}
