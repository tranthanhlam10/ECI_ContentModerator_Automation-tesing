package Tests;

import APIs.BaseSetup;
import APIs.CardsApis;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CardsTest extends BaseSetup {

    CardsApis cardsApis = new CardsApis();
    File schemaPartialDeck = new File("src/test/resources/patial_card_schema.json");
    File schemaAddPiles = new File("src/test/resources/add_piles_schema.json");
    File schemaListCard = new File("src/test/resources/list_card_schema.json");
    File schemaDrawPiles = new File("src/test/resources/draw_piles_schema.json");
    File schemaReturnCard = new File("src/test/resources/return_card_schema.json");

    @BeforeMethod
    public void setCardsApis(){
        cardsApis.setUpURL();
    }

    @Test
    public void partialDeck(){

        Response res = cardsApis.partialDeck();

        //res.then().assertThat().body(matchesJsonSchema(schemaPartialDeck));
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();

        // Kiem tra theo TestNG
//        Assert.assertEquals(jsonPath.get("remaining").toString(), "12");
//        Assert.assertTrue(jsonPath.get("shuffled"));

        // Kiem tra theo Hamcrest
        assertThat(jsonPath.get("remaining"), is(greaterThanOrEqualTo(10)));
        assertThat(jsonPath.get("shuffled") , contains("false"));
    }

//    @Test
//    public void addingToPiles(){
//        Response res = cardsApis.addingToPiles();
//
//        //res.then().assertThat().body(matchesJsonSchema(schemaAddPiles));
//        res.prettyPrint();
//
//        JsonPath jsonPath = res.jsonPath();
//
//        // Kiem tra theo TestNG
//        Assert.assertEquals(jsonPath.get("deck_id"), "62us34z8yq9y");
//        Assert.assertEquals( jsonPath.get("piles.LamMaiChungTinhViEm.remaining").toString(), "0");
//
//        // Kiem tra theo Hamcrest
//        assertThat(jsonPath.get("deck_id"), is(not(contains("Lamdeptraicotaicuagai"))));
//        assertThat(jsonPath.get("piles.LamMaiChungTinhViEm"), is(nullValue()));
//    }
//
//    @Test
//    public void shufflesPiles(){
//        Response res = cardsApis.shufflesPiles();
//
//        //res.then().assertThat().body(matchesJsonSchema(schemaAddPiles));
//        res.prettyPrint();
//
//        JsonPath jsonPath = res.jsonPath();
//
//        // Kiem tra theo TestNG
//        Assert.assertEquals(jsonPath.get("remaining").toString(),"46");
//
//        // Kiem tra theo Hamcrest
//        assertThat(jsonPath.get("remaining"), is(lessThan(53)));
//
//    }
//
//    @Test
//    public void listCardInPiles(){
//        Response res = cardsApis.listCardInPiles();
//        res.prettyPrint();
//
//        //res.then().assertThat().body(matchesJsonSchema(schemaListCard));
//        JsonPath jsonPath = res.jsonPath();
//
//        // Kiem tra theo TestNG
//        Assert.assertEquals(jsonPath.get("deck_id"),"62us34z8yq9y" );
//        Assert.assertNotNull(jsonPath.get("piles.Lamdeptrai.cards"));
//
//        // Kiem tra theo Hamcrest
//        assertThat(jsonPath.get("deck_id"), equalToCompressingWhiteSpace("62us34z8yq9y"));
//        assertThat(jsonPath.get("piles.Lamdeptrai.cards") ,  is(nullValue()));
//    }
//
//    @Test
//    public void drawFromPiles(){
//        Response res = cardsApis.drawFromPiles();
//
//        //res.then().assertThat().body(matchesJsonSchema(schemaDrawPiles));
//        res.prettyPrint();
//
//        JsonPath jsonPath = res.jsonPath();
//        System.out.println(jsonPath.get("error").toString());
//
//        // Kiem tra theo TestNG
//        Assert.assertEquals(jsonPath.get("error"), "Not enough cards remaining to draw 2 additional");
//
//        // Kiem tra theo Hamcrest
//        assertThat(jsonPath.get("error"), anyOf(startsWith("Not enough cards remaining to draw 2 additional"), containsString("Lam dep trai qua troi dep")));
//    }
//
//    @Test
//    public void returnCardToDeck(){
//        Response res = cardsApis.returnCardToDeck();
//
//        //res.then().assertThat().body(matchesJsonSchema(schemaReturnCard));
//        res.prettyPrint();
//
//        JsonPath jsonPath = res.jsonPath();
//
//        // Kiem tra theo TestNG
//        Assert.assertFalse(jsonPath.get("success"));
//
//        // Kiem tra theo Hamcrest
//        assertThat(jsonPath.get("success") , is("true"));
//    }

}
