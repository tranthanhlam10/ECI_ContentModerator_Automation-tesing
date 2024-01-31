package APIs;

import Objects.Model;
import Objects.Model_Update;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ModelAPIs {
    public void setUpBasePath(){
        basePath = "/eca";
    }

    String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOjU4MTIsImlkIjo1ODEyLCJ1c2VyIjp7ImlkIjo1ODEyLCJlbWFpbCI6ImxhbXR0QHlvdW5ldGdyb3VwLmNvbSIsInBob25lIjoiMDAwMDAwMDAwMCIsImZ1bGxuYW1lIjoiTMOibSBUVCJ9LCJpYXQiOjE2OTUxMzE1MTcsImV4cCI6MTY5NzcyMzUxNywiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiNTgxMiIsImp0aSI6IjQwYWIwMzRiLWFhYjctNGYzYy1hYjIxLWZjZTY3NzBjZDdiZCJ9.-GcJfFR2HoOJtJHHrdawojAWEdVgz2K-XNm2R6zGaZc";

    public Response getListModels(){
        String endpoint_getlist_1 = "view-product-models";
        return given().auth().oauth2(access_token).when().get(endpoint_getlist_1);
    }

    public Response createModels(){

        String endpoint_addModel = "/models?$eager=product_line.[brand,industry]";

        Model model = new Model();
        model.setDisplay_name("Brand New abc Lam auto");
        model.setProduct_line_id(1);
        model.setQuery_exactly(0);



        return given().auth().oauth2(access_token).contentType("application/json").when().body(model).post(endpoint_addModel);
    }

    public Response updateModel(){
        String endpoint_updateModel = "/models/17407?$eager=product_line.[brand,industry]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Model_Update model_update = new Model_Update();
        model_update.setDisplay_name("Brand New abc xyz");
        model_update.setName("");
        model_update.setProduct_line_id(2);
        model_update.setQuery_exactly(0);
        model_update.setQuery("Samsung");


        return given().auth().oauth2(access_token).when().body(model_update).put(endpoint_updateModel);
    }

    public Response deleteModel(){
        String endpoint_deleteModel = "/models/17407";
        return given().auth().oauth2(access_token).when().delete(endpoint_deleteModel);
    }








}
