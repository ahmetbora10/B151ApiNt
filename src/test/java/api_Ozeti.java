public class api_Ozeti {
    /*
      ****Api Nedir?****
-Api (Application Programming Interface) yani Uygulama Programlama Arayüzüdür.
Bir uygulamaya ait işlevlerin ve üretilen verilerin başka uygulamalarda da kullanılabilmesi
için geliştirilen arayüzün adina API denir. Örneğin hem mobil uygulama hemde web uygulama kullanılan
bir sistemde bu uygulamaların hem kendi içerisinde hemde server ile sağlıklı iletişim kurabilmesi için
ayni dili konuşması gerekiyor. Bu diller içerisinde en yaygın olanı SOAP ve REST dir.
-API’ ı bir restoranda garson olarak düşünelim.
 Bir garson olarak, API bir istemciden bir istek alır (Request), bu isteği veri tabanına alır, istenen verileri veri
 tabanından alır ve istemciye bir yanıt (Response) döndürür.
 -API testi, API‘ ın bir uygulamanın işlevselliği, güvenilirliği, performansı ve güvenliği açısından beklentileri karşılayıp
  karşılamadığını kontrol etmek için yapılır.
  API testi uygulamanın görnümü ile ilgilenmez.
  -API ve Web Service uygulamalar arasında iletişim oluştururlar.
  -Bütün Web Service’ler API’dır. Ancak bütün API’lar Web Service
   değildir.
   Web Service
   Aralarındaki tek fark Web Service iki uygulama arasındaki iletişimi internet aracılığı ile yapar.
   API
   Microsoft Word gibi masaüstü uygulamaları, internete ihtiyaç duymayan kendi API‘ larını kullanır.
   Bu yüzden Microsoft Word kullandığımızda Microsoft Word API kullanıyoruz
***Swagger***
-Swagger’ın önemli bir amacı RestApi ler için bir arayüz sağlamaktır.
Bu hem insanların hemde bilgisayarlara kaynak koda erişmeden RestApi lerin özelliklerini görmesine,
incelemesine ve anlamasına olanak sağlar.
-Swagger,Apı'larınızın yapısını tanımlamanıza olanak tanıyan bir frameworkdur.
-API belgeleri için SWAGGER kullandım.
 SWAGGER bana API endpoint’leri veriyor ve bunların nasıl kullanılacağı
 hakkında beni bilgilendiriyor.
 HTTP Status Kodları
200 (OK) ==> Talep karşılandı. Request gerçekleşti.
201 (CREATED) ==> Database’ e gönderilen datanın oluşturulduğunu söyler. (200 olarak da gelebilir)
204 (NO CONTENT) ==> Talep yerine getirildi ancak size cevap (response) dönemiyoruz.
400 (BAD REQUEST) ==> Syntax yanlış, yüksek boyutlu data ya da diğer kullanıcı hatası...
403 (FORBIDDEN) ==> Bu dataya erişim izniniz yok. (400 olarak da gelebilir)
404 (NOT FOUND) ==> Aranılan data bulunamadı.
500 (INTERNAL SERVER ERROR) ==> Server kaynaklı bir hatadır, server’ın düzelmesini bekleriz.
200 başarılı(OK)
404 bulunamadı(NOT FOUND)
500 sunucu hatası(SERVER FAIL)
201 created(olusturuldu)
Serialization
-Java objesinin Json datasına çevirilmesi.
-De-Serialization
Json datasının Java objesine çevrilmesi.
Postman, geliştiricilerin API’ları oluşturmasını, paylaşmasını ve test etmesini ve
belgelemesini sağlayan popüler bir uygulamadır.
***SOAP UI****
SOAP  Simple Object Access Protocol. (Basit Nesne Erişim Protokolü)
-Web uygulamalarının internet üzerinden haberleşebilmesi önemlidir.
HTTP, tüm internet tarayıcıları ve sunucuları tarafından desteklendiğinden, uygulamalar arasında iletişim
kurmanın en iyi yolu HTTP üzerindendir. SOAP bunu başarmak için oluşturulmuştur.
SOAP, farklı teknolojiler ve programlama dilleri ile farklı işletim sistemlerinde çalışan uygulamalar arasında iletişim
kurmak için bir yol veya biçim sağlar. SOAP platformlardan bağımsızdır
REST  REpresentational State Transfer
-REST sistemlerin birbirleri ile iletişim kurmalarını kolaylaştırır.
REST mimarisinde, client’ lar dataları almak (retrive) veya değiştirmek (modify) için request gönderir ve
server’lar bu request’lere response gönderir.
REST , XML ve JSON (Java Script Object Notation) formatlarının ikisini de kullanabilir. Bu sebeple SOAP dan daha
yaygın bir kullanımı vardır
API Endpoint Nedir?
API’ın istek gönderdiği ve kaynagın yaşadığı yer endpoint’tir. API developer’lar bir API
oluşturduğunda genel endpoint’ler (URL) oluştururlar ve hangi endpoint’in hangi
HTTP Request yöntemleriyle çalışacağına karar verirler
     */
}
