package Tests;

import APIs.BaseSetup;
import APIs.BrandAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyString;




public class BrandTest extends BaseSetup {
    BrandAPIs brandAPIs = new BrandAPIs();
    final String GET_LIST_BRAND_SCHEMA = "get_list_brand_schema.json";
    final String CREATE_BRAND_SCHEMA = "create_brand_schema.json";
    final String UPDATE_BRAND_SCHEMA = "update_brand_schema.json";
    final String DELETE_BRAND_SCHEMA = "delete_brand_schema.json";

    @BeforeTest
    public void setBrandApis(){
       brandAPIs.setUpBasePath();
    }

    @Test
    public void getListBrandDefault() throws IOException {

        Response res = brandAPIs.getListBrands();
        res.prettyPrint();


        int status_code = res.statusCode();
        //String content_type = res.contentType();

        assertThat(status_code, is(200));
        //assertThat(content_type, is("application/json"));


    }
    //@Test(dataProvider = "excelData_Brand", dataProviderClass = ExcelReader.class)
    @Test
    public void createBrand(String brand_name){

        Response res = brandAPIs.createBrands();
        res.prettyPrint();
        int status_code = res.statusCode();
        String content_type = res.contentType();

        JsonPath jsonPath = res.jsonPath();


        // check Json Schema by Json Validator
       // assert  create_brand_schema != null;

        // check by Hamcrest
        // Kiem tra header API
        assertThat(status_code, is(200));
        assertThat(content_type, is("application/json"));

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten model duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("name"), is("Lam Test Autoamtion"));
        // Kiem tra manufacturer duoc tao co giong voi id da truyen vao khong
        assertThat(jsonPath.get("manufacturer_id"), is(100));

        System.out.println(brand_name);


    }

    @Test
    public void updateBrand(){

        Response res = brandAPIs.updateBrand();
        res.prettyPrint();
//        InputStream update_brand_schema = getClass().getClassLoader()
//                .getResourceAsStream("update_brand_schema.json");

        int status_code = res.statusCode();
        String content_type = res.contentType();
        JsonPath jsonPath = res.jsonPath();

        // check by Hamcrest
        assertThat(status_code, is(200));
        assertThat(content_type, is("application/json"));


        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten model duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("name"), is("Lam Test Autoamtion"));
        // Kiem tra manufacturer duoc tao co giong voi id da truyen vao khong
        assertThat(jsonPath.get("manufacturer_id"), is(100));

    }

    @Test
    public void deleteBrand() {

        Response res = brandAPIs.deleteBrand();
        res.prettyPrint();
        InputStream delete_brand_schema = getClass().getClassLoader()
                .getResourceAsStream("delete_brand_schema.json");

        int status_code = res.statusCode();
        String content_type = res.contentType();

        JsonPath jsonPath = res.jsonPath();

        // check Json Schema by Json Validator
        assert  delete_brand_schema != null;
       // res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFileReader.JsonFileReader(DELETE_BRAND_SCHEMA)));

        // check by Hamcrest
        assertThat(status_code, is(200));
        assertThat(content_type, is("application/json"));

        // Check null response
        assertThat(jsonPath.prettyPrint(), is(emptyString()));
        // Kiem tra ten brand duoc tao co giong voi ten da truyen vao khong
        assertThat(jsonPath.get("name"), is("Lam Test Autoamtion"));
        // Kiem tra manufacturer duoc tao co giong voi id da truyen vao khong
        assertThat(jsonPath.get("manufacturer_id"), is(100));
    }

}
