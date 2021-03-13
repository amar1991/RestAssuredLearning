import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class MainClass {

    public static void main(String[] args) {

        //Add Place API
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // given - input details
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","Application/Json")
                .header("X-Auth-Token","464e2e8ffd8b41a4ba9d80def7adecc0")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")

        // when - submit the api - resource, http method
        .when().post("maps/api/place/add/json")

        // then - validate response
        .then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.18 (Ubuntu)");
    }

}
