package APIs;

import Objects.Brand;
import io.restassured.response.Response;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class BrandAPIs {
    public void setUpBasePath(){
        basePath = "/eca";
    }


    // String là kiểu dữ liệu tham chiếu
    String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6ImFjY2VzcyJ9.eyJ1c2VySWQiOjU4MTIsImlkIjo1ODEyLCJ1c2VyIjp7ImlkIjo1ODEyLCJlbWFpbCI6ImxhbXR0QHlvdW5ldGdyb3VwLmNvbSIsInBob25lIjoiMDAwMDAwMDAwMCIsImZ1bGxuYW1lIjoiTMOibSBUVCJ9LCJpYXQiOjE3MTk1MTU0NDgsImV4cCI6MTcyMjEwNzQ0OCwiYXVkIjoiaHR0cHM6Ly95b3VyZG9tYWluLmNvbSIsImlzcyI6ImZlYXRoZXJzIiwic3ViIjoiNTgxMiIsImp0aSI6IjQ2NDgyMDU1LWQ5ZDYtNDhiNi1hMzU0LWVmZDAxOWNmN2M4OSJ9.29Cn5ossMU-h6EfugfQe1IBQPSJDMKUD1PvBGA1fo2o";

    public Response getListBrands(){
        String endpoint_getlist = "/brands";
        return given().auth().oauth2(access_token).when().get(endpoint_getlist);

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

        return given().auth().oauth2(access_token).contentType("application/json").when().body(brand).post(endpoint_addBrand);
    }

    public Response updateBrand(){
        String endpoint_updateBrand = "/brands/33?$eager=[manufacturer]";
        // Cho ID nay nen su ly bang cach truyen file vao doc ID
        // Tao mot file excel doc het cac properties do len

        Brand brand = new Brand();
        brand.setName("Lam Test Automation");
        brand.setManufacturer_id(100);


        return given().auth().oauth2(access_token).when().body(brand).put(endpoint_updateBrand);
    }

    public Response deleteBrand(){
        String endpoint_deleteBrand = "/brands/17407";
        return given().auth().oauth2(access_token).when().delete(endpoint_deleteBrand);
    }


}
