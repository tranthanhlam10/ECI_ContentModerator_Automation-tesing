package Tests;

import APIs.BrandAPIs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyString;


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
        int status_code = res.statusCode();
        String content_type = res.contentType();

        // check by Hamcrest
        assertThat(status_code, is(200));
        assertThat(content_type, is("application/json"));


    }
    @Test
    public void createBrand(){

        Response res = brandAPIs.createBrands();
        res.prettyPrint();

        int status_code = res.statusCode();
        String content_type = res.contentType();

        JsonPath jsonPath = res.jsonPath();

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



        // check by Hamcrest


    }

    @Test
    public void updateBrand(){

        Response res = brandAPIs.updateBrand();
        res.prettyPrint();

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
    public void deleteBrand(){

        Response res = brandAPIs.deleteBrand();
        res.prettyPrint();

        int status_code = res.statusCode();
        String content_type = res.contentType();

        JsonPath jsonPath = res.jsonPath();

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
