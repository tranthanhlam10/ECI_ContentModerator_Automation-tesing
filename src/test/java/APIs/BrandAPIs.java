package APIs;

import Objects.Brand;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class BrandAPIs {
    public void setUpBasePath(){
        basePath = "/eca";
    }

    String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOjU4MTIsImlkIjo1ODEyLCJ1c2VyIjp7ImlkIjo1ODEyLCJlbWFpbCI6ImxhbXR0QHlvdW5ldGdyb3VwLmNvbSIsInBob25lIjoiMDAwMDAwMDAwMCIsImZ1bGxuYW1lIjoiTMOibSBUVCJ9LCJpYXQiOjE2OTUxMzE1MTcsImV4cCI6MTY5NzcyMzUxNywiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiNTgxMiIsImp0aSI6IjQwYWIwMzRiLWFhYjctNGYzYy1hYjIxLWZjZTY3NzBjZDdiZCJ9.-GcJfFR2HoOJtJHHrdawojAWEdVgz2K-XNm2R6zGaZc";

    public Response getListBrands(){
        String endpoint_getlist = "/brands";
        return given().auth().oauth2(access_token).when().get(endpoint_getlist);
    }

    public Response createBrands(){

        String endpoint_addBrand = "/brands?$eager=[manufacturer]";

        Brand brand = new Brand();
        brand.setName("Lam Test Autoamtion");
        brand.setManufacturer_id(100);

        return given().auth().oauth2(access_token).contentType("application/json").when().body(brand).post(endpoint_addBrand);
    }

    public Response updateBrand(){
        String endpoint_updateBrand = "/brands/33?$eager=[manufacturer]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Brand brand = new Brand();
        brand.setName("Lam Test Autoamtion");
        brand.setManufacturer_id(100);


        return given().auth().oauth2(access_token).when().body(brand).put(endpoint_updateBrand);
    }

    public Response deleteBrand(){
        String endpoint_deleteBrand = "/brands/17407";
        return given().auth().oauth2(access_token).when().delete(endpoint_deleteBrand);
    }


}
