package Day03.Day03;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C03_Exercise {

        // POST https://deprem.afad.gov.tr/EventData/GetEventsByFilter

    @Test
    public void afad(){

        // Request body de take degeri ne gonderilirse response da eventList size i o kadar olmalidir

        String body = "{\"EventSearchFilterList\":[{\"FilterType\":9," +
                "\"Value\":\"2023-07-12T19:38:39.894Z\"},{\"FilterType\":8," +
                "\"Value\":\"2023-07-11T19:38:39.894Z\"}]," +
                "\"Skip\":0," +
                "\"Take\":20," +
                "\"SortDescriptor\":{\"field\":\"eventDate\",\"dir\":\"desc\"}}";

        Response response = given().
                baseUri("https://deprem.afad.gov.tr").
                accept("application/json").
                contentType("application/json").
                body(body).
            when().
                post("/EventData/GetEventsByFilter");

        response.then().log().all();

        response.
                then().
                statusCode(200).
                header("Content-Type","application/json; charset=utf-8").
                body("eventList", hasSize(20)).
                body("eventList[0].magnitude", lessThan(5.0F)); // ilk deprem eventinin magnitude unun 5 ten
        // kucuk oldugunu kontrol edelim

    }

}