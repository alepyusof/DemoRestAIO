import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class DemoRestAIO {
    String accessToken;
    String bookingId;
    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://auth-api-uat.getgo.sg")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }
    @Test (priority = 1)
    public void login() {
        String requestBody = "{\n" +
                "  \"countryCode\": \"65\",\n" +
                "  \"phoneNumber\": \"90000002\"\n" +
                "}";
        given().
                header("Authorization", "Basic R0ctVUFULWZwbWJuQFI2WSY6UXU3V28jdCF6QjhlOFI=").
                body(requestBody).
                when().
                post("/v1/Authentication/Login").
                then().
                assertThat().
                body("error_msg", is(equalTo("Success")));
    }
    @Test (priority = 2)
    public void verifyPin() {
        String requestBody = "{\n" +
                "  \"countryCode\": \"65\",\n" +
                "  \"deviceId\": \"37AB1900-6AEC-4D30-B128-30209472D5DA\",\n" +
                "  \"deviceType\": \"ios\",\n" +
                "  \"phoneNumber\": \"90000002\",\n" +
                "  \"pinCode\": \"202020\",\n" +
                "  \"deviceToken\": \"\"\n" +
                "}";
        accessToken =
        given().
                header("Authorization", "Basic R0ctVUFULWZwbWJuQFI2WSY6UXU3V28jdCF6QjhlOFI=").
                body(requestBody).
                when().
                post("/v1/Authentication/VerifyPin").
                then().
                assertThat().
                body("data.accessToken", is(not(empty()))).
                extract().response().jsonPath().get("data.accessToken");
    }
    @Test (dependsOnMethods = {"login", "verifyPin"})
    public void getProfile() {
        given().
                baseUri("https://api-uat.getgo.sg").
                header("Authorization", "Bearer " + accessToken).
                when().
                get("/v1/Account/GetProfile").
                then().
                assertThat().
                body("data.fullName", is((equalTo("Salim Macan"))));
    }
        /*
        1. /v1/Vehicle/GetCarParkList
        2. /v1/Vehicle/GetVehicleDetail
        3. /v1/Booking/CreateBooking
        */
//    @Test (dependsOnMethods = "getProfile")
//    public void createBooking() {
//        String requestBody = "{\n" +
//                "  \"schedule_end_date\" : \"2023-01-19T11:15:00Z\",\n" +
//                "  \"schedule_start_date\" : \"2023-01-19T10:15:00Z\",\n" +
//                "  \"payment_type\" : 1,\n" +
//                "  \"vehicle_id\" : \"052dc9fa-3c54-4560-b080-61c86de7bc6a\",\n" +
//                "  \"promocode\" : \"\",\n" +
//                "  \"cdw_insurance\" : false\n" +
//                "}";
//        bookingId =
//        given().
//                baseUri("https://api-uat.getgo.sg").
//                header("Authorization", "Bearer " + accessToken).
//                body(requestBody).
//                when().
//                post("/v2/Booking/CreateBooking").
//                then().
//                assertThat().
//                body("data.bookingNo", is(not(empty())),
//                        "data.id", is(not(empty())),
//                        "error_msg", is(equalTo("Success")),
//                        "data.status", is(equalTo("CONFIRMED"))).
//                extract().response().jsonPath().get("data.id");
//    }
//    @Test (dependsOnMethods = "createBooking")
//    public void getBookingDetail() {
//        given().
//                baseUri("https://api-uat.getgo.sg").
//                header("Authorization", "Bearer " + accessToken).
//                queryParam("bookingId", bookingId).
//                when().
//                get("/v1/Booking/GetBookingDetail").
//                then().
//                assertThat().
//                body("data.bookingNo", is(not(empty())),
//                        "data.id", is(not(empty())),
//                        "error_msg", is(equalTo("Success")),
//                        "data.status", is(equalTo("CONFIRMED")));
//    }
}