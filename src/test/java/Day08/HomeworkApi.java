package Day08;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class HomeworkApi {
    //GET: https://fakerapi.it/api/v1/companies?_quantity=5
    @Test
    public void quantityNumber() {
        int quantity = 5;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(5));

    }
    @Test
    public void quantityDefault() {
     String quantity = null;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(0));
    }
    @Test
    public void quantityMin() {
        int quantity = 1;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1));

    }


    @Test
    public void quantityMax() {
        int quantity = 1000;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1000));

    }

    @Test
    public void quantityten() {
        int quantity = 10;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(10));

    }
    @Test
    public void quantityNegative() {
        int quantity = -4;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(0));

    }

    @Test
    public void quantityHighLevel() {
        int quantity = 1001;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1000));

    }
    @Test
    public void quantityCharacter() {
        char quantity = 'a';
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(0));

    }

    @Test
    public void quantitySpace() {
        char quantity = ' ';
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(0));

    }

    @Test
    public void quantityEmty() {
        char quantity = ' ';
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(10));

    }

    @Test
    public void quantityDoubleMin() {
        double quantity = 1.0;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1));

    }
    @Test
    public void quantityDoubleMax() {
        double quantity = 1000.0000;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1000));

    }
    @Test
    public void quantityDouble() {
        double quantity = 1000.1;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(1000));

    }
    @Test
    public void quantityDoubleMiddle() {
        double quantity = 15.0;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(15));

    }
    @Test
    public void quantityDoubleMiddleTwo() {
        double quantity = 15.1;
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(16));

    }
    @Test
    public void quantitySymbol() {
        String quantity = "$";
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(0));

    }
    @Test
    public void quantitySquare() {
        String quantity = "#";
        Response response = RestAssured.given().

                baseUri("https://fakerapi.it/api/v1").
                queryParam("_quantity", quantity).
                log().all().
                when().
                get("/books");
        response.then().statusCode(200);
        response.then().log().all();
        response.then().body("total", equalTo(10));

    }




    }