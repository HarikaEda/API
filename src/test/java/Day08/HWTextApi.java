package Day08;

import Pojo.Exercises.TextPojoData;
import Pojo.Exercises.TextPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HWTextApi {
    @Test
    public void text() {
//GET:https://fakerapi.it/api/v1/texts?_quantity=1&_characters=500
        int characters = 500;
        Response getResponse = RestAssured.
                given().
                queryParam("_quantity", 1).
                queryParam("_characters", characters).
                when().
                get("https://fakerapi.it/api/v1/texts?_quantity=1&_characters=500");

        getResponse.then().statusCode(200);
        getResponse.then().log().all();

        TextPojoData response = getResponse.as(TextPojoData.class);
        TextPojo text=new TextPojo();

     //Assrt doğrulamalarını tamamla!!!!!!!!!!!!



    }
}