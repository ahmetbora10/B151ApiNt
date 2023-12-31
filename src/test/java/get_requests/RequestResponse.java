package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    NOTLAR

        1- Manuel API testi için Postman kullanıyoruz.
        2- API otomasyon testi için REST Assured kütüphanesini kullanıyoruz.
        3- Otomasyon kodlarının yazımı için şu adımları izleriz:
            A- Gereksinimleri anlama
            B- Test senaryosu yazma
                a- Test senaryosu yazmak içi Gherkin dilini kullanıyoruz.
                    - Given: Endpoint, body ...
                    - When: get, put, post gibi işlemler
                    - Then: Assertion, Close ...
                    - And: Çoklu işlemlerin art arda yapıldığı zaman kullanılır.
            C- Otomasyon kodlarını yazarken şu adımları izleriz:
                 i- Set the URL = URL'i tanımla
                ii- Set the expected data = Beklenen dataları ayarla
               iii- Send the request and get the response = İsteği gönder ve cevabı al
                iv- Do assertion = Doğrulama yap
     */

    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/3435";
        Response response = given().when().get(url);
      response.prettyPrint();

       //Status code nasil yazdirilir
        System.out.println("status  code:" + response.statusCode());
        System.out.println("__________________________");

        // Content Type nasıl yazdırılır?
        System.out.println("Content Type=" + response.contentType());
        System.out.println("__________________________");

        // Content Type nasıl yazdırılır?
        System.out.println("Content Type: " + response.contentType());
        System.out.println("__________________________");
        // Status Line nasıl yazdırılır?
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("__________________________");
        // Header'daki veriler nasıl yazdırılır?
        System.out.println("Header | Server: " + response.header("Server"));
        System.out.println("__________________________");
        System.out.println("Header | Connection: " + response.header("Connection"));
        System.out.println("__________________________");
        // Headers nasıl yazdırılır?
        System.out.println("Headers: " + response.headers());
        System.out.println("__________________________");
        // Time nasıl yazdırılır?
        System.out.println("Time: " + response.time());
         /*
        Request ==> istek
        Response ==> istege gonderilen cevap
        Status code = Gelen cevabin basari durumu
        Post ==> creat ==> Request olusturma islemi => Istek olusturma
        Get ==> read ==>Request sorgulama => Istegin olusup olusmadigini veya
        verilen url deki bilgilerin dogrulugunu sorgulama
        Put ==> update ==> Request i update etme => Istegi guncelleme
        Delete ==> delete ==> Request'i delete etme => Istegi silme islemi
        Bu islemlere kisaca CRUD islemleri denir
         */
        //Status Code nasil yazdirilir?
        System.out.println("Status code: "+response.statusCode());

        //Content Type nasil yazdirilir?
        System.out.println("Content type: "+response.contentType());


        //Status Line nasil yazdirilir?     ==> Status Code ile birbirine benzer bu sadece HTTP protokol versiyonunu da verir
        System.out.println("Status line: " + response.statusLine());

    }

}
