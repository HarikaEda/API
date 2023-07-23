package Day07;

import Pojo.reqres.Support;
import Pojo.reqres.UpdateUserResponse;
import Pojo.reqres.User;
import Pojo.reqres.UserRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_Practice {

        // API Testing

        // API testi sadece bir API in farkli requestlere verdigi response larin kontrol edilmesiyle bitmez.
        // API lar 2 goreve sahiptir.
        //      1. API client a yaptigi islemle ilgili bilgi vermek durumundadir (Response - status code, body, header)
        //      2. API in (gorevi) functionu - API lar belirli islemleri gerceklestirmek icin olusturulurlar

        // Bu gorevler veri cekme, veri olusturma, veri guncelleme ve veri silme olabilir.
        // Bununla beraber API lar canli ogeler olup bazi datalar ile trigger edilebilirler.

        // API larin fonsiyonlarina gore testler de olusturmaliyiz.
        // Bir API in response unun dogru olmasi bu API in gorevini tam anlamiyla yerine getirdigi anlamina gelmez.
        // Bu yuzden API testi cift tarafli dusunulmelidir.

        // 1 - API nin response unun test edilmesi
        // 2 - API nin efektinin test edilmesi

        // Reqres.in PUT Update a user API i kullaniciyi update edebilmeli ve
        // update edilen kullanici bilgilerini response da yansitmalidir

        @Test(description = "User should update user with valid request body")
        public void updateUser() {

            int userId = 1;

           UserRequest userRequest = new UserRequest();
            User user = new User();
            Support support = new Support();

            //data valuesunun olusturulmasi
            user.setEmail("karl@reqres.in");
            user.setFirst_name("Karl");
            user.setLast_name("Ortis");
            user.setAvatar("https://reqres.in/img/faces/1-image.jpg");
            user.setId(userId);

            // olusturulan data valuesunun fielda atanmasi
            userRequest.setData(user);

            // support value sunun olusturulmasi
            support.setUsl("https://reqres.in/#support-heading");
            support.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

            // support value sunun support field ina set edilmesi
            userRequest.setSupport(support);

            Response response = RestAssured.
                    given().
                    baseUri("https://reqres.in/api").
                    pathParam("userId", userId).
                    accept("application/json").
                    contentType("application/json").
                    body(userRequest).log().body().
                    when().
                    put("/users/{userId}");

            response.then().statusCode(200);

            UpdateUserResponse updateUserResponse = response.as(UpdateUserResponse.class);


            // 1- Numarali maddeyi test ettik yani requeste karsilik gelen response dogrulandi

            Assert.assertEquals(updateUserResponse.getData().getEmail(), userRequest.getData().getEmail());
            Assert.assertEquals(updateUserResponse.getData().getFirst_name(), userRequest.getData().getFirst_name());
            Assert.assertEquals(updateUserResponse.getData().getLast_name(), userRequest.getData().getLast_name());
            Assert.assertEquals(updateUserResponse.getData().getAvatar(), userRequest.getData().getAvatar());

            // 2. maddeye geldik. API response u dogru duruyor. Bakalim API imiz gorevini gercekten yerine getiriyor mu?

            // GET requesti yardimi ile database den asil veriyi fetch ediyoruz (Asil derken response daki data yerine DB deki data temsil ediliyor)

            Response getResponse = RestAssured.given().
                    baseUri("https://reqres.in/api").
                    pathParam("userId", userId).
                    accept("application/json").
                    when().get("/users/{userId}");

            getResponse.then().statusCode(200);

            getResponse.prettyPrint();
            //Class imiz UserRequest olarak gozukse de response da bu yapi kullanildigi icin ortak class kullaniliyor
            UserRequest userResponse = getResponse.as(UserRequest.class);

            Assert.assertEquals(userResponse.getData().getId(), userRequest.getData().getId());
            Assert.assertEquals(userResponse.getData().getEmail(), userRequest.getData().getEmail());
            Assert.assertEquals(userResponse.getData().getFirst_name(), userRequest.getData().getFirst_name());
            Assert.assertEquals(userResponse.getData().getLast_name(), userRequest.getData().getLast_name());
            Assert.assertEquals(userResponse.getData().getAvatar(), userRequest.getData().getAvatar());

            // API miz dogru response uretse de fonksiyonunu tam olarak yerine getirmiyor!!!
            // Bu sayede su yorumu yapabiliriz.

            // API lar sadece request ve response lara bakilarak test edilirse bizi yanlis bulgulara surukleyebilir.
        }
    }

