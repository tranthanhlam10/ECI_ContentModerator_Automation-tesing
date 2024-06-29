package APIs;

import Objects.Brand;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class BrandAPIs {
    public  void setUpBasePath(){
        basePath = "/eca";
    }




    public Response getListBrands(){

        String endpoint_getlist = "/brands";
        return given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOjU4MTIsImlkIjo1ODEyLCJ1c2VyIjp7ImlkIjo1ODEyLCJlbWFpbCI6ImxhbXR0QHlvdW5ldGdyb3VwLmNvbSIsInBob25lIjoiMDAwMDAwMDAwMCIsImZ1bGxuYW1lIjoiTMOibSBUVCJ9LCJpYXQiOjE3MTk1MTcyMDUsImV4cCI6MTcyMjEwOTIwNSwiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiNTgxMiIsImp0aSI6ImZmN2I3OTUzLWFmZDEtNGU1MC04M2ZjLTk5NGIzZWEwNmZjMyJ9.G2waV6NP7E9h5yPNGNSaPFzS_d0BBkbp-hEMBA42SnQ").when().get(endpoint_getlist);

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

        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").contentType("application/json").when().body(brand).post(endpoint_addBrand);
    }

    public Response updateBrand(){
        String endpoint_updateBrand = "/brands/33?$eager=[manufacturer]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Brand brand = new Brand();
        brand.setName("Lam Test Automation");
        brand.setManufacturer_id(100);


        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").when().body(brand).put(endpoint_updateBrand);
    }

    public Response deleteBrand(){
        String endpoint_deleteBrand = "/brands/17407";
        return given().auth().basic("lamtt@younetgroup.com","Lam@12345").when().delete(endpoint_deleteBrand);
    }


}
