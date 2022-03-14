package MyExample;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class WeatherApi {
    String baseUrl = "https://yahoo-weather5.p.rapidapi.com";

    @Test
    public void getWeather() {
        String endpoint = "/weather?location=Yerevan";


                 given().baseUri(baseUrl).
                contentType(ContentType.JSON).


                header("X-RapidAPI-Key", "22f9b1c97bmsh9fd60b638c59275p1d5c23jsnbbf3b55f5c2f").
               // header("X-RapidAPI-Host","yahoo-weather5.p.rapidapi.com").

                when().get(endpoint).
                then().log().all().assertThat().body("location.city",equalTo("Yerevan")).
                         body("forecasts[0].day",equalTo("Mon"));

    }
}