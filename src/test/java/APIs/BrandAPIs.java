package APIs;

import Objects.Brand;
import io.restassured.response.Response;
import utils.PropertiesReader;
import utils.RandomString;

import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.*;

public class BrandAPIs {

    static Logger logger = Logger.getLogger("BaseSetup");

    public void setUpBasePath() throws IOException {

        String env = BaseSetup.getEnv();
        System.out.println(env);
        basePath = PropertiesReader.getProperty("src/test/resources/environments/" + env + "-env.properties", "basePath");

    }

    private String getToken() {
        return  Authencation.getInstance().getToken();
    }

    public Response getListBrands(){

        String endpoint_getlist = "/brands";

        return given().auth().oauth2(getToken()).when().get(endpoint_getlist);

    }




    //int, double, float là các kiểu dữ liệu nguyên thuỷ
    //kiểu dữ liệu tham chiếu thì cũng có rất nhiều dạng (class, string, interface)
    //mọi biến trong Java phải được khai báo thì mới có thể sử dụng
    //trong quá trính khai báo, thì thường tạo giá trị ban đầu danh cho biến (nta hay gọi là khỏi tạo giá trị khia báo ban đầu)
    //Prefit < Toán tử < Assignment < Postfit (được tính toán từ trái qua phải)
    public Response createBrandsValidation(){

        String endpoint_addBrand = "/brands?$eager=[manufacturer]";

        Brand brand = new Brand();
        brand.setName("Lam Test Brand Automation " + RandomString.getRandomString());
        brand.setManufacturer_id(100);
        brand.setIs_active(0);

        return given().auth().oauth2(getToken()).contentType("application/json").when().body(brand).post(endpoint_addBrand);
    }

    public Response updateBrandValidation(int brand_id){
        String endpoint_updateBrand = "/brands/" + brand_id + "?$eager=[manufacturer]";

        Brand brand = new Brand();
        brand.setName("Lam Test Update Brand Automation " + RandomString.getRandomString());
        brand.setManufacturer_id(100);
        brand.setIs_active(0);


        return given().auth().oauth2(getToken()).contentType("application/json").when().body(brand).patch(endpoint_updateBrand);
    }

    public Response deleteBrandValidation(int brand_id){
        String endpoint_deleteBrand = "/brands/" + brand_id;
        return given().auth().oauth2(getToken()).contentType("application/json").when().delete(endpoint_deleteBrand);
    }


}
