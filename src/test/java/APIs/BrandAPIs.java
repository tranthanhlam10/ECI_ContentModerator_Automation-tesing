package APIs;

import Objects.Brand;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class BrandAPIs {

    Authencation authencation = new Authencation();
    public  void setUpBasePath(){
        basePath = "/eca";
    }


    public Response getListBrands(){

        String endpoint_getlist = "/brands";
        return given().auth().oauth2(authencation.getToken()).when().get(endpoint_getlist);

    }



    //int, double, float là các kiểu dữ liệu nguyên thuỷ
    //kiểu dữ liệu tham chiếu thì cũng có rất nhiều dạng (class, string, interface)
    //mọi biến trong Java phải được khai báo thì mới có thể sử dụng
    //trong quá trính khai báo, thì thường tạo giá trị ban đầu danh cho biến (nta hay gọi là khỏi tạo giá trị khia báo ban đầu)
    //Prefit < Toán tử < Assignment < Postfit (được tính toán từ trái qua phải)
    public Response createBrands(){

        String endpoint_addBrand = "/brands?$eager=[manufacturer]";

        Brand brand = new Brand();
        brand.setName("Lam Test Autoamtion");
        brand.setManufacturer_id(100);

        return given().auth().oauth2(authencation.getToken()).contentType("application/json").when().body(brand).post(endpoint_addBrand);
    }

    public Response updateBrand(){
        String endpoint_updateBrand = "/brands/33?$eager=[manufacturer]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Brand brand = new Brand();
        brand.setName("Lam Test Automation");
        brand.setManufacturer_id(100);


        return given().auth().oauth2(authencation.getToken()).when().body(brand).put(endpoint_updateBrand);
    }

    public Response deleteBrand(){
        String endpoint_deleteBrand = "/brands/17407";
        return given().auth().oauth2(authencation.getToken()).when().delete(endpoint_deleteBrand);
    }


}
