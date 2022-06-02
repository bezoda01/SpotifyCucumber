package definitions;

import api.SpotifyApi;
import api.SpotifyApiParam;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import models.ResponseModel;
import models.TokenModel;

import static api.SpotifyApi.getToken;
import static con.Constants.testData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.JsonUtils.jsonStringToObject;

public class ApiSearchTest {
    public ResponseModel model;

    @When("^User search track \"([^\"]*)\", artist \"([^\"]*)\" for GET inquiry$")
    public void user_search_track_artist_for_GET_inquiry(String arg1, String arg2) {
       model = getTrackModel(arg1, arg2);
    }

    @Then("^Request equals \"([^\"]*)\"$")
    public void request_equals(String arg1) {
        checkRequestStatus(arg1);
    }

    @Then("Request contains correct track {string}, and correct artist {string}")
    public void requestContainsCorrectTrackAndCorrectArtist(String arg0, String arg1) {
        checkRequestContainsCorrectTrackNameAndArtist(arg0, arg1);
    }

    @Step("Get Tack Model")
    public ResponseModel getTrackModel(String trackName, String artist) {
        TokenModel token = jsonStringToObject(getToken(testData.get("clientId").toString(), testData.get("clientSecret").toString()).getBody(), TokenModel.class);
        SpotifyApi api = new SpotifyApi(token.getTokenType(), token.getAccessToken());
        return api.searchWithNameAndType(trackName, artist, SpotifyApiParam.TRACK_TYPE);
    }

    @Step("Check request status code")
    public void checkRequestStatus(String expectedStatusCode) {
        assertEquals(Integer.valueOf(expectedStatusCode), model.getStatusCode(), "Status code is not correct");
    }

    @Step("Check request contains correct track name and artist")
    public void checkRequestContainsCorrectTrackNameAndArtist(String trackName, String artist) {
        assertTrue(model.getBody().contains(trackName), "Request was not contains correct track");
        assertTrue(model.getBody().contains(artist), "Request was not contains correct artist");
    }
}
