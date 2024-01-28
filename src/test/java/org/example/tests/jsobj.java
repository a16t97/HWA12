package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class jsobj {
    final String api = "https://fakerestapi.azurewebsites.net/api/v1";

    @Test
    public void postUsers() {
        final String endpointName = "/Users";
        String url = api + endpointName;

        var json = new JSONObject();
        json.put("id", 123);
        json.put("userName", "user123");
        json.put("password", "password123");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(json.toString())
                .post(url);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

