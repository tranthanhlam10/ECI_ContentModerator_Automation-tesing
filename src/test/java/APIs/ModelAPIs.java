package APIs;

import Objects.Model;
import Objects.Model_Update;
import io.restassured.response.Response;
import utils.PropertiesReader;
import utils.RandomString;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class ModelAPIs {
    public void setUpBasePath() throws IOException {

        String env = BaseSetup.getEnv();
        basePath = PropertiesReader.getProperty("src/test/resources/environments/" + env + "-env.properties", "basePath");
        System.out.println("Property value: " + basePath);

    }

    private String getToken() {
        return  Authencation.getInstance().getToken();
    }


    public Response getListModelsValidation(){
        String endpoint_getlist = "view-product-models";
        System.out.println("Trần Thanh Lâm");
        return given().auth().oauth2(getToken()).when().get(endpoint_getlist);
    }

    public Response createModelsValidation(){

        String endpoint_addModel = "/models?$eager=product_line.[brand,industry]";

        Model model = new Model();
        model.setDisplay_name("Lam Test Model Automation " + RandomString.getRandomString());
        model.setProduct_line_id(1);
        model.setQuery_exactly(0);
        model.setQuery("Samsung");

        return given().auth().oauth2(getToken()).contentType("application/json").when().body(model).post(endpoint_addModel);
    }

    public Response updateModelValidation(int model_id){
        String endpoint_updateModel = "/models/"+ model_id +"?$eager=product_line.[brand,industry]";

        Model_Update model_update = new Model_Update();
        model_update.setDisplay_name("Lam Test Update Model Automation " + RandomString.getRandomString() );
        model_update.setName("");
        model_update.setProduct_line_id(2);
        model_update.setQuery_exactly(0);
        model_update.setQuery("Samsung");


        return given().auth().oauth2(getToken()).when().body(model_update).put(endpoint_updateModel);
    }

    public Response deleteModelValidation(int model_id){
        String endpoint_deleteModel = "/models/"+model_id;
        return given().auth().oauth2(getToken()).when().delete(endpoint_deleteModel);
    }




}
