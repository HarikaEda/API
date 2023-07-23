package Day06;

import Pojo.petstore.Pet;
import Pojo.reqres.User;
import com.sun.net.httpserver.Request;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Exercises {
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
        public void test() {
        int petId=10;
        Response getPetResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                pathParam("petId", petId).
        when().
                get("/pet/{petId}");
        getPetResponse.then().statusCode(200);
        System.out.println("getPetResponse = " + getPetResponse);

        Pet putPetRequest = getPetResponse.as(Pet.class);
        putPetRequest.setName("Foggiiee");

        Response putPetResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType("application/json").
                body(putPetRequest).
        when().
                put("/pet");
        putPetResponse.then().statusCode(200);
        System.out.println("putPetResponse = " + putPetResponse);
        //putPetResponse.then().log().all();

        Response deletePetResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType("application/json").
                pathParam("petId", petId).
        when().
                delete("/pet/{petId}");
                deletePetResponse.then().statusCode(200);
        System.out.println("deletePetResponse = " + deletePetResponse);
        deletePetResponse.then().log().everything();
        

    }
}
