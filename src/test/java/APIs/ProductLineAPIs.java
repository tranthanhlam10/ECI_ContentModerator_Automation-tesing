package APIs;

import Objects.ProductLine;
import io.restassured.response.Response;
import utils.PropertiesReader;
import utils.RandomString;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class ProductLineAPIs {
    public void setUpBasePath(){
        PropertiesReader reader = BaseSetup.getPropertiesReader();
        basePath = reader.getProperty("basePath");
        System.out.println("Property value: " + basePath);
    }

    private String getToken() {
        return  Authencation.getInstance().getToken();
    }
    public Response getListProductLineValidation(){
        String endpoint_getlist = "product-lines";
        return given().auth().oauth2(getToken()).when().get(endpoint_getlist);
    }

    public Response createProductLinesValidation(){

        String endpoint_addProductLine = "/product-lines?$eager=[brand,industry]";

        ProductLine productLine = new ProductLine();
        productLine.setName("Lam Test Product Line Automation " + RandomString.getRandomString() );
        productLine.setBrand_id(1);
        productLine.setIndustry_id(1);

        return given().auth().oauth2(getToken()).contentType("application/json").when().body(productLine).post(endpoint_addProductLine);
    }

    public Response updateProductLinesValidation(int product_line_id){

        String endpoint_updateProductLine = "/product-lines/"+ product_line_id +"?$eager=[brand,industry]";

        ProductLine productLine = new ProductLine();
        productLine.setName("Lam Test Update Product Line Automation" + RandomString.getRandomString());
        productLine.setBrand_id(1);
        productLine.setIndustry_id(1);

        return given().auth().oauth2(Authencation.getInstance().getToken()).contentType("application/json").when().body(productLine).put(endpoint_updateProductLine);
    }

    public Response deleteProductLineValidation(int product_line_id){
        String endpoint_deleteProductLine = "/product-lines/"+ product_line_id;
        return given().auth().oauth2(getToken()).when().delete(endpoint_deleteProductLine);
    }


}
