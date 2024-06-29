package APIs;

import Objects.ProductLine;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class ProductLineAPIs {
    public void setUpBasePath(){
        basePath = "/eca";
    }
    String access_token =  "eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOjU4MTIsImlkIjo1ODEyLCJ1c2VyIjp7ImlkIjo1ODEyLCJlbWFpbCI6ImxhbXR0QHlvdW5ldGdyb3VwLmNvbSIsInBob25lIjoiMDAwMDAwMDAwMCIsImZ1bGxuYW1lIjoiTMOibSBUVCJ9LCJpYXQiOjE3MTk1MTU0NDgsImV4cCI6MTcyMjEwNzQ0OCwiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiNTgxMiIsImp0aSI6IjQ2NDgyMDU1LWQ5ZDYtNDhiNi1hMzU0LWVmZDAxOWNmN2M4OSJ9.29Cn5ossMU-h6EfugfQe1IBQPSJDMKUD1PvBGA1fo2o";


    public Response getListProductLine(){
        String endpoint_getlist = "product-lines";
        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").when().get(endpoint_getlist);
    }

    public Response createProductLines(){

        String endpoint_addProductLine = "/product-lines?$eager=[brand,industry]";

        ProductLine productLine = new ProductLine();
        productLine.setName("Thanh Lam Test Automation");
        productLine.setBrand_id(1);
        productLine.setIndustry_id(1);

        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").contentType("application/json").when().body(productLine).post(endpoint_addProductLine);
    }

    public Response updateProductLines(){

        String endpoint_updateProductLine = "/product-lines/9622?$eager=[brand,industry]";

        ProductLine productLine = new ProductLine();
        productLine.setName("Thanh Lam Test Automation 2");
        productLine.setBrand_id(1);
        productLine.setIndustry_id(1);

        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").contentType("application/json").when().body(productLine).put(endpoint_updateProductLine);
    }

    public Response deleteProductLine(){
        String endpoint_deleteProductLine = "/product-lines/9630";
        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").when().delete(endpoint_deleteProductLine);
    }


}
