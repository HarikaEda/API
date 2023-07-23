package Day04.Day04;

import Pojo.restfulbooker.Booking;
import Pojo.restfulbooker.BookingDates;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class C04_RequestPOJO {

    @Test
    public void pojo(){

        // (subjektif yorum) POJO API automation da en onem arz eden konulardan biridir.

        // POST https://restful-booker.herokuapp.com/booking

        // Request body sini POJO class imizi kullanarak olusturuyoruz
        Booking booking = new Booking();

        booking.setFirstname("Karl");
        booking.setLastname("Ortis");
        booking.setTotalprice(311);
        booking.setDepositpaid(false);
        booking.setAdditionalneeds("Kahvalti");

        // Request body sinde ic ice olan her bir json objesi icin POJO objesi uretiyoruz
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-02-02");
        bookingDates.setCheckout("2024-02-02");

        booking.setBookingdates(bookingDates);

        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(booking). // requestimizi POJO objemizi body methoduna koyarak yapiyoruz
                log().body().
            when().
                post("/booking");

        response.then().statusCode(200);

    }
}