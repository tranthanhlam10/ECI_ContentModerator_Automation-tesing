package APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class DeckApis {

    public void setupURL(){
        basePath = "/api/deck";
    }

    // xao bai
    public Response shuffeDeck(){
       // basePath = "/api/deck";
        return given().get("/new/shuffle/?deck_count=1");
    }

    // xao lai bai
    public Response reShuffeDeck(){

        return given().get("62us34z8yq9y/shuffle/?remaining=true");
    }

    // rut bai tu bo bai
    public Response drawCardsForDeck(){

        return given().get("62us34z8yq9y/draw/?count=2");
    }

    // tao bo bai moi
    public Response createNewDeck(){
        return given().get("/new");
    }


}
