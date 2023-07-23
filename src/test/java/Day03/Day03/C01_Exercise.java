package Day03.Day03;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Exercise {

    // PATCH  https://restful-booker.herokuapp.com/booking/:id

    @Test
    public void exercise(){

        // baseURI         +
        // header - contentType accept     +
        // body    +
        // auth - Cookie header         +
        // path param     +

        String bodyString = "{\"firstname\" : \"Karl\",\"lastname\" : \"Ortis\"}";

        Response response = given().
                baseUri("https://restful-booker.herokuapp.com").
                header("Cookie", "token=d92aadb018edd24").
                contentType("application/json").
                accept("application/json").
                body(bodyString).
                pathParam("bookingId", 200).log().all().
                when().
                patch("/booking/{bookingId}");

        response.then().log().all();
        response.then().statusCode(200);

    }


  /*  @Test
    public void example() {
//https://restful-booker.herokuapp.com/booking/:id
        String body = "'{\n" +
                "    \"firstname\" : \"Emine\",\n" +
                "    \"lastname\" : \"Dişçeken\"\n" +
                "}'";
        Response respo = given().baseUri("https://restful-booker.herokuapp.com").
                header("Cookie", " token=f97ac0a53da477a").
                contentType("application/json").
                accept("application/json").
                body(body).
                pathParam("Id", 201).log().all().
                when().patch("/booking/{Id}");
        respo.then().log().all();
        respo.then().statusCode(200);

//io.restassured.internal.http.HttpResponseException: status code: 400, reason phrase: Bad Request
    }
*/




}
