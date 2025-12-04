import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class ApiTests {

    @Test
    public void getTest() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/1");

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode, "Статус код має бути 200");

        System.out.println("GET test passed!");
    }

    @Test
    public void createPostTest() {

        Post myPost = new Post();
        myPost.userld = 1;
        myPost.body = "This is a body content";
        myPost.title = "Auto title";

        Post responsePost = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType(ContentType.JSON)
                .body(myPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .as(Post.class);


        Assertions.assertEquals("Auto title", responsePost.title);

        System.out.println("POST test passed!");
    }
}