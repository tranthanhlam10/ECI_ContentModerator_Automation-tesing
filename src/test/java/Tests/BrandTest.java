package Tests;

import APIs.BaseSetup;
import APIs.BrandAPIs;
import ObjectResponse.BrandResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.logging.Logger;


import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BrandTest extends BaseSetup {

    static Logger logger = Logger.getLogger("BaseSetup");


    BrandAPIs brandAPIs = new BrandAPIs();
    final String GET_LIST_BRAND_SCHEMA = "Schema/Brand/get_list_brand_schema.json";
    final String CREATE_BRAND_SCHEMA = "Schema/Brand/create_brand_schema.json";
    final String UPDATE_BRAND_SCHEMA = "Schema/Brand/update_brand_schema.json";
    final String DELETE_BRAND_SCHEMA = "Schema/Brand/delete_brand_schema.json";

    private int brand_id;

    @BeforeMethod
    public void setBrandApis() throws IOException {
       brandAPIs.setUpBasePath();
    }

    @Test
    public void getListBrandDefaultValidation() throws IOException {


        logger.warning("basePath" + basePath);
        logger.warning("current baseURI" + baseURI);

        Response res = brandAPIs.getListBrands();
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(GET_LIST_BRAND_SCHEMA));
    }
    //@Test(dataProvider = "excelData_Brand", dataProviderClass = ExcelReader.class)
    @Test
    public void createBrandValidation(){

        Response res = brandAPIs.createBrandsValidation();
        res.prettyPrint();

        BrandResponse brandRes = res.jsonPath().getObject("", BrandResponse.class);
        brand_id = brandRes.getId();

        res.then().assertThat().statusCode(201);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(CREATE_BRAND_SCHEMA));

    }

    @Test
    public void updateBrandValidation(){

        Response res = brandAPIs.updateBrandValidation(brand_id); // Nếu code như vầy là nó sẽ tạo hàm gọi 1 hàm tạo mới khác trước khi nó update
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(UPDATE_BRAND_SCHEMA));

    }

    @Test
    public void deleteBrandValidation() {

        Response res = brandAPIs.deleteBrandValidation(brand_id);
        res.prettyPrint();

        res.then().assertThat().statusCode(200);
        res.then().assertThat().body(matchesJsonSchemaInClasspath(DELETE_BRAND_SCHEMA));
    }

}
