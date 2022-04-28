package Tests;

import APIs.BaseSetup;
import APIs.DeckApis;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class DeckTest extends BaseSetup {

    DeckApis deckApis = new DeckApis();

    File schemaShufflDeck = new File("src/test/resources/shuffe_card_schema.json");
    File schemaReShuffeDeck = new File("src/test/resources/draw_card_schema.json");
    File schemaDrawCard= new File("src/test/resources/reshuffe_card_schema.json");
    File schemaCreateDeck= new File("src/test/resources/patial_card_schema.json");


    @BeforeClass
    public void setDeckApis(){
        deckApis.setupURL();
    }

    @Test
    public void shuffeDeck()  {

        Response res = deckApis.shuffeDeck();

        res.then().assertThat().body(matchesJsonSchema(schemaShufflDeck));
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();

        // Kiem tra theo TestNG
        Assert.assertEquals(jsonPath.get("remaining").toString(), "52");

        // Kiem tra theo Hamcrest
        assertThat(jsonPath.get("remaining").toString(), is(equalTo("52")));
        assertThat(jsonPath.get("remaining"), greaterThan(20));

    }

    @Test
    public void reShuffeDeck(){

        Response res = deckApis.reShuffeDeck();

        //res.then().assertThat().body(matchesJsonSchema(schemaReShuffeDeck));
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();


        // Kiem tra theo TestNG
        Assert.assertEquals(jsonPath.get("deck_id"), "62us34z8yq9y", "Correct DeckID return");
        Assert.assertEquals(jsonPath.get("remaining").toString(), "52", "Xao bai khong bi mat bai");

        // Kiem tra theo Hamcrest
        assertThat(jsonPath.get("deck_id"), equalTo("62us34z8yq9y"));
        assertThat(jsonPath.get("remaining"), is("52"));

    }

    @Test
    public void drawCardsForDeck(){
        Response res = deckApis.drawCardsForDeck();

        //res.then().assertThat().body(matchesJsonSchema(schemaDrawCard));
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();

        // Kiem tra theo TestNG
        Assert.assertEquals(jsonPath.get("cards[0].value"), "5");
        Assert.assertEquals(jsonPath.get("cards[0].suit"), "HEARTS");
        Assert.assertEquals(jsonPath.get("deck_id"), "3p40paa87x90");

        // Kiem tra theo Hamcrest
        assertThat(jsonPath.get("cards[0].value") , is("5"));
        assertThat(jsonPath.get("cards[0].suit"), allOf(startsWith("HEARTS"), containsString("HER")));

    }

    // API nay da kiem tra xong
    @Test
    public void createNewDeck(){
        Response res = deckApis.createNewDeck();

        //res.then().assertThat().body(matchesJsonSchema(schemaCreateDeck));
        res.prettyPrint();

        JsonPath jsonPath = res.jsonPath();

        // Kiem tra theo TestNG
        Assert.assertEquals(jsonPath.get("remaining").toString(), "52" );

        // Kiem tra theo Hamcrest
        assertThat(jsonPath.get("remaining"), is("52"));
    }
}
