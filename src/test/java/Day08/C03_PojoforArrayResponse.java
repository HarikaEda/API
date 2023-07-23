package Day08;

import Pojo.restfulbooker.Booking;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class C03_PojoforArrayResponse {
    // 1. JSON Array in request olarak gonderilmesi

    // 2. JSON Array in response dan okunmasi

@Test
    public void testPojoforArrayResponse() {
// 2. Practice

    Response response = RestAssured.given().
            baseUri("https://restful-booker.herokuapp.com").
            when().get("/booking");
    response.prettyPrint();
// Deserialize to ArrayList of Map
    ArrayList bookingResponse = response.as(ArrayList.class);

    for (int i = 0; i < bookingResponse.size(); i++) {
        System.out.println(bookingResponse.get(i));
    }

    // Deserialize to array of Booking - recommended
    Booking[] bookingArray = response.as(Booking[].class);

    ArrayList<Booking> bookingArrayList = new ArrayList<>(Arrays.asList(bookingArray));

    System.out.println(bookingResponse);
}


}


