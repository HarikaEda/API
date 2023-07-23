package Day05;
import Pojo.petstore.Pet;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class C03_Practice {


    @Test
    public void practice() {

        int petId = 10;

        // Ilk get requesti ile guncellenecek olan hayvan java objesi olarak alinir

        Response getPetResponse = given().
                baseUri("https://petstore.sapplication/jsonwagger.io/v2").
                accept("").
                pathParam("petId", petId).
                when().
                get("/pet/{petId}");

        getPetResponse.then().statusCode(200);
        System.out.println("-------------------------------------------------------------------------");
        getPetResponse.then().log().body();
        Pet putRequestBody = getPetResponse.as(Pet.class);

        // Guncellenecek fieldlar guncellenir

        ArrayList<String> updatedList = new ArrayList<>(Arrays.asList("Foto1", "Foto2", "Foto3"));

        putRequestBody.setName("Pamuk");
        putRequestBody.setPhotoUrls(updatedList);

        // Guncellenen Pet ile put requesti atilir ve pet guncellenir
        Response putPetResponse = given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType("application/json").
                body(putRequestBody).
                when().
                put("/pet");

        putPetResponse.then().statusCode(200);
        System.out.println("-------------------------------------------------------------------------");
        putPetResponse.then().log().body();

        // Guncellenen pet in guncellenen alanlari kontrol edilir
        Response finalGetResponse = given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                pathParam("petId", petId).
                when().
                get("/pet/{petId}");

        finalGetResponse.then().statusCode(200);
        System.out.println("-------------------------------------------------------------------------");
        finalGetResponse.then().log().body();

        Pet updatedPet = finalGetResponse.as(Pet.class);

        // Pet in name mini Pamuk olarak degistirmistik, kontrol ediyoruz
        Assert.assertEquals(updatedPet.getName(), "Pamuk");

        // Pet in photoUrl leri arasinda gezinerek bu Url lerin tek tek degisip degismedigine bakiyoruz
        for (int i = 0; i < updatedPet.getPhotoUrls().size(); i++) {
            String currentPhoto = updatedPet.getPhotoUrls().get(i);
            Assert.assertTrue(updatedList.indexOf(currentPhoto) >= 0);
        }

    }
}




















