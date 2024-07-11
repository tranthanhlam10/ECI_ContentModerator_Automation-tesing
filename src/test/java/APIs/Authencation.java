package APIs;


import Objects.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

public class Authencation extends BaseSetup {
    User user = new User();

    public Authencation(){
        user.setPassword("Lam@12345");
        user.setEmail("lamtt@younetgroup.com");
        user.setStrategy("local");
    }
    public String getToken(){

        basePath = "";
        Response res = given().header("Content-Type", "application/json").body(user).when().post("/authentication");
        //res.prettyPrint();

        System.out.println(baseURI + basePath +"/authentication" );

        JsonPath jsonPath = res.jsonPath();
        System.out.println("Token "+ jsonPath.getString("accessToken"));

        return jsonPath.getString("accessToken");


    }
}
