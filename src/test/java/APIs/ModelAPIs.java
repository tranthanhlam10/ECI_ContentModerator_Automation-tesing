package APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class ModelAPIs {
    public void setUpURL(){
        basePath = "/eca";
    }

    public Response getListModels(){
        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").get("view-product-models?%24select%5B%5D=id&%24select%5B%5D=name&%24select%5B%5D=display_name&%24select%5B%5D=query&%24select%5B%5D=product_line_id&%24select%5B%5D=product_line_name&%24select%5B%5D=brand_id&%24select%5B%5D=brand_name&%24select%5B%5D=industry_id&%24select%5B%5D=industry_name&%24select%5B%5D=created_by&%24select%5B%5D=created_at&%24select%5B%5D=updated_by&%24select%5B%5D=updated_at&page_access=management&%24sort%5Bcreated_at%5D=-1&%24select%5B%5D=query_exactly&industry_id=1&%24limit=10");
    }

}
