package step_definitions;
// step definitions comes from feature file
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

    // in Before annotation, i set up my URI and path. it executes before all steps
    @Before
    public void setup(){
        RestAssured.baseURI= "http://v2eok.mocklab.io/";
        RestAssured.basePath = "customer/";
    }



    //here setting the endpoint
    @Given("I set GET test api endpoint")
    public void i_set_GET_test_api_endpoint()  {
        requestSpec = given()
                .pathParam("path","a");
    }




    // here sending GET request and assigning to response object.
    @When("Send GET HTTP request")
    public void send_GET_HTTP_request()  {

        response =  requestSpec.when().get("{path}");

    }


    //testing the status code in response is 200 or not. if its not 200 it fails.
    @Then("I recevive valid HTTP response code {int}")
    public void i_recevive_valid_HTTP_response_code(Integer int1) {
        //int1 comes from {int}, and {int} comes from feature file
        response.then().statusCode(int1);

    }


    //this is deserialization, i create a java object from a json data
    @Then("I create Person object from HTTP response body")
    public void i_create_Person_object_from_HTTP_response_body() {
        person = response.getBody().as(Person.class);

    }


    //testing if id is positive or not
    @Then("I validate id is bigger than {int}")
    public void i_validate_id_is_bigger_than(Integer int1) {

        Assert.assertTrue(person.getId()>int1);
    }


    //testing name string length is smaller than 11
    @Then("I validate name length is smaller than {int}")
    public void i_validate_name_length_is_smaller_than(Integer int1) {

        Assert.assertTrue(person.getName().length()<int1);
    }



    //testing last string length is smaller than 11
    @Then("I validate lastname length is smaller than {int}")
    public void i_validate_lastname_length_is_smaller_than(Integer int1) {
        Assert.assertTrue(person.getLast().length()<int1);
    }



    //testing the age value is between 0 and 120
    @Then("I validate age is between {int} and {int}")
    public void i_validate_age_is_between_and(Integer int1, Integer int2) {
        //int1 and int2 comes from {int}s, and {int}s comes from feature file
        Assert.assertTrue(person.getAge()>int1 && person.getAge()<int2);
    }


    //testing gender value is "F" or "M"
    @Then("I validate gender is {string} or {string}")
    public void i_validate_gender_is_or(String string, String string2) {
        Assert.assertTrue(person.getGender().equals(string)||person.getGender().equals(string2));
    }



    //testing response time is smaller than 500ms
    @Then("I validate response time is smaller {int} ms")
    public void i_validate_response_time_is_smaller_ms(Integer int1) {
        // there is a special method, getTime(),  from responseOptions interfce
        Assert.assertTrue(response.getTime()<int1);

    }


    // testing the response is a desired json format, its generally told in API document
    @Then("I validate the schema data types")
    public void i_validate_the_schema_data_types() {
        PersonDataType personDataType = new PersonDataType(person);
        // object mapper is used for converting java object to json, this is called serialization
        ObjectMapper mapper = new ObjectMapper();
        PersonDataType personDataType1=null;  // to compare i need one more object
        String path = System.getProperty("user.dir"); // i used user.dir because my json file has a path which contains my local disk name. (C:\\...)
                                                        // it means that it only works in my machine so I used user.dir
        try {
            personDataType1= mapper.readValue(new File(path + "\\src\\test\\resources\\persondatatype.json"),PersonDataType.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //testing whether i get as a response,  correct structure of json or not.
        Assert.assertEquals(personDataType1.toString(),personDataType.toString());
    }


}


