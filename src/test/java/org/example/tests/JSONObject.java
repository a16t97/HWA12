package org.example.tests;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JSONObject {
    final String api = "https://fakerestapi.azurewebsites.net/api/v1";
    OkHttpClient client = new OkHttpClient.Builder().build();

    @Test
    public void testAddNewUser() throws IOException {
        final String endpointName = "/Users";
        String url = api + endpointName;

        org.json.JSONObject json = new org.json.JSONObject();
        json.put("id", 123);
        json.put("userName", "User123");
        json.put("password", "Password123");

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Assert.assertEquals(response.code(), 200, "Status code should be 200 Created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JSONObject::PUT@" + Thread.currentThread().getName());
    }
}
