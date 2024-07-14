package APIs;

import Objects.Model;
import Objects.Model_Update;
import io.restassured.response.Response;
import utils.RandomString;

import static io.restassured.RestAssured.*;

public class ModelAPIs {
    Authencation authencation = new Authencation();
    public void setUpBasePath(){
        basePath = "/eca";
    }


    public Response getListModelsValidation(){
        String endpoint_getlist = "view-product-models";
        return given().auth().oauth2(authencation.getToken()).when().get(endpoint_getlist);
    }

    public Response createModelsValidation(){

        String endpoint_addModel = "/models?$eager=product_line.[brand,industry]";

        Model model = new Model();
        model.setDisplay_name("Lam Test Model Automation " + RandomString.getRandomString());
        model.setProduct_line_id(1);
        model.setQuery_exactly(0);
        model.setQuery("Samsung");

        return given().auth().oauth2(authencation.getToken()).contentType("application/json").when().body(model).post(endpoint_addModel);
    }

    public Response updateModelValidation(int model_id){
        String endpoint_updateModel = "/models/"+ model_id +"?$eager=product_line.[brand,industry]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Model_Update model_update = new Model_Update();
        model_update.setDisplay_name("Lam Test Update Model Automation " + RandomString.getRandomString() );
        model_update.setName("");
        model_update.setProduct_line_id(2);
        model_update.setQuery_exactly(0);
        model_update.setQuery("Samsung");


        return given().auth().oauth2(authencation.getToken()).when().body(model_update).put(endpoint_updateModel);
    }

    public Response deleteModelValidation(int model_id){
        String endpoint_deleteModel = "/models/"+model_id;
        return given().auth().oauth2(authencation.getToken()).when().delete(endpoint_deleteModel);
    }








}
