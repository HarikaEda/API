package Day06;

import Pojo.Exercises.PostStore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Exercises3 {


    @Test
    public void test1() {
        PostStore postStore=new PostStore();
        postStore.setId(10);
        postStore.setPetId(10);
        postStore.setQuantity(10);
        postStore.setShipDate("2023-07-18T13:38:50.013Z");
        postStore.setStatus("placed");
        postStore.setComplete(true);



        Response postStoreResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType(ContentType.JSON).
                body(postStore).
                log().body().
           when().
                post( "/store/order");

        postStoreResponse.then().statusCode(200);
        System.out.println("postStoreResponse = " + postStoreResponse);

        Response getStoreResponse = RestAssured.given().
                baseUri("https://petstore.swagger.io/v2").
                accept("application/json").
                contentType(ContentType.JSON).
                log().all().
        when().
                get( "/store/order/10");
        getStoreResponse.then().log().all().statusCode(200);













    }

}
