package stepDefinitions;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jruby.RubyProcess;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class CheckResponseStepDefs {
    @Given("a test")
    public void aTest() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("https://jsonplaceholder.typicode.com/users");

        String jsonString = response.asString();

        System.out.println(jsonString);

        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);
    }

    @Given("this is a task")
    public void anotheMathod() {
        System.out.println(" 11 ");
    }
}
