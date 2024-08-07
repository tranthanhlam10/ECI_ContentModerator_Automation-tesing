package APIs;


import Objects.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;


public class Authencation extends BaseSetup {


    public static Authencation authencation;
    public static String token;

    User user = new User();

    // Hàm khỏi tạo sẽ được tạo một lần khi khỏi tạo class, nên là vẫn gán giá trị được bình thường
    private Authencation() {
        user.setPassword("Lam@12345");
        user.setEmail("lamtt@younetgroup.com");
        user.setStrategy("local");
    }

    //Phương thức tĩnh cung cấp thể hiện duy nhất của lớp. Nếu thể hiện chưa tồn tại, nó sẽ được tạo mới.
    public static Authencation getInstance(){
        if (authencation == null) {
            authencation = new Authencation();
        }
        return authencation;
    }


    public  String getToken(){

        basePath = "";
        Response res = given().header("Content-Type", "application/json").body(user).when().post("/authentication");
        //res.prettyPrint();

        System.out.println(baseURI + basePath +"/authentication" );

        JsonPath jsonPath = res.jsonPath();
        System.out.println("Token "+ jsonPath.getString("accessToken"));

        token = jsonPath.getString("accessToken");

        return token;


    }

}
