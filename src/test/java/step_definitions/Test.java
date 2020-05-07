package step_definitions;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.Person;
import pojo.PersonDataType;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test {
    RequestSpecification requestSpec;
    Response response;
    Person person;

    @Before
    public void setup(){
        RestAssured.baseURI= "http://v2eok.mocklab.io/";
        RestAssured.basePath = "customer/";
    }

    @Given("I set GET test api endpoint")
    public void i_set_GET_test_api_endpoint()  {
        requestSpec = given()
                .pathParam("path","a");
    }

    @When("Send GET HTTP request")
    public void send_GET_HTTP_request()  {

        response =  requestSpec.when().get("{path}");

    }

    @Then("I recevive valid HTTP response code {int}")
    public void i_recevive_valid_HTTP_response_code(Integer int1) {

        response.then().statusCode(int1);

    }

    @Then("I create Person object from HTTP response body")
    public void i_create_Person_object_from_HTTP_response_body() {
        person = response.getBody().as(Person.class);

    }

    @Then("I validate id is bigger than {int}")
    public void i_validate_id_is_bigger_than(Integer int1) {

        Assert.assertTrue(person.getId()>int1);
    }

    @Then("I validate name length is smaller than {int}")
    public void i_validate_name_length_is_smaller_than(Integer int1) {

        Assert.assertTrue(person.getName().length()<int1);
    }

    @Then("I validate lastname length is smaller than {int}")
    public void i_validate_lastname_length_is_smaller_than(Integer int1) {
        Assert.assertTrue(person.getLast().length()<int1);
    }

    @Then("I validate age is between {int} and {int}")
    public void i_validate_age_is_between_and(Integer int1, Integer int2) {
        Assert.assertTrue(person.getAge()>int1 && person.getAge()<int2);
    }

    @Then("I validate gender is {string} or {string}")
    public void i_validate_gender_is_or(String string, String string2) {
        Assert.assertTrue(person.getGender().equals(string)||person.getGender().equals(string2));
    }

    @Then("I validate response time is smaller {int} ms")
    public void i_validate_response_time_is_smaller_ms(Integer int1) {
        Assert.assertTrue(response.getTime()<int1);

    }

    @Then("I validate the schema data types")
    public void i_validate_the_schema_data_types() {
        PersonDataType personDataType = new PersonDataType(person);
        ObjectMapper mapper = new ObjectMapper();
        PersonDataType personDataType1=null;
        String path = System.getProperty("user.dir");
        try {
            personDataType1= mapper.readValue(new File(path + "\\src\\test\\resources\\persondatatype.json"),PersonDataType.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(personDataType1.toString(),personDataType.toString());
    }


}


