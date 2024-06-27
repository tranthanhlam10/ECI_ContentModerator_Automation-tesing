package APIs;

import Objects.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class AuthencationAPIs {

    public void setUpBasePath(){
        basePath = "/eca";
    }


    public Response getToken(){
        String endpoint_authencation_eci = "/authentication";

        User user= new User();
        user.setEmail("lamtt@younetgroup.com");
        user.setPassword("Lam@12345");
        user.setStrategy("local");

        return given().contentType("application/json").when().body(user).post(endpoint_authencation_eci);
    }
}
