package APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class CardsApis {

    public void setUpURL(){
        basePath = "/api/deck";
    }

    // tao bo bai nho
    public Response partialDeck(){
        return given().queryParam("cards","AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH").get("/new/shuffle");
    }

    // them bai vao bo bai nho
    public Response  addingToPiles(){
        return given().queryParam("cards", "AS,2S").get("/5fmcwt5mkc1e/pile/LamMaiChungTinhViEm/add");
    }

    // xao lai bo bai nho
    public Response shufflesPiles(){
        return given().get("5fmcwt5mkc1e/pile/LamMaiChungTinhViEm/shuffle");
    }

    // xem danh sach la bai trong bo bai nho
    public Response listCardInPiles(){
        return given().get("5fmcwt5mkc1e/pile/LamMaiChungTinhViEm/list/");
    }

    // rut bai tu bo bai nho
    public Response drawFromPiles(){
        return given().queryParam("count", "2").get("https://deckofcardsapi.com/api/deck/5fmcwt5mkc1e/pile/LamMaiChungTinhViEm/draw");
    }

    // bo bai lai bo bai nho
    public Response returnCardToDeck(){
        return given().queryParam("cards","AS,2S").get("/5fmcwt5mkc1e/return");
    }


}
