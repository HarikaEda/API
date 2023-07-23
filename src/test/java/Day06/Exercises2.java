package Day06;

import Pojo.petstore.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercises2 {

   /*
{
  "id": 10,
  "category": {
    "id": 10,
    "name": "sample string"
  },
  "name": "doggie",
  "photoUrls": [
    "sample 1",
    "sample 2",
    "sample 3"
  ],
  "tags": [
    {
      "id": 10,
      "name": "sample string"
    },
    {
      "id": 10,
      "name": "sample string"
    }
  ],
  "status": "available"
}
*/
//https://petstore.swagger.io/v2/pet/10
    @Test
    public void exercises2() {

         int pathId = 10;
        Response getPhotoUrlsResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType("application/json").
                pathParam("petId", pathId).
        when().
                get("/pet/{petId}");
        getPhotoUrlsResponse.
        then().
                statusCode(200).
                log().
                all();

        System.out.println(getPhotoUrlsResponse.getBody().prettyPrint());

        Pet putPhotoUrlsRequest = getPhotoUrlsResponse.as(Pet.class);
        ArrayList<String>updatedList = new ArrayList<>(Arrays.asList("photo 1", "photo 2", "photo 3"));

        putPhotoUrlsRequest.setPhotoUrls(updatedList);
        Response putPhotoUrlsResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType("application/json").
                //pathParam("petId", pathId).
                body(putPhotoUrlsRequest).
        when().
                put("/pet");
        putPhotoUrlsResponse.
                then().
                statusCode(200).
                log().
                all();



    }





}
