package org.example.tests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.example.tests.dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JacksonTests {

    final String api = "https://fakerestapi.azurewebsites.net/api/v1";
    OkHttpClient client = new OkHttpClient.Builder().build();

    @Test
    public void getUsers() {
        final String endpointName = "/Users";
        String url = api + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "text/plain; v=1.0")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            Assert.assertEquals(code, 200, "Responce code must be 200, but got " + code + " instead");
            var mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            var users = mapper.readValue(response.body().string(), User[].class);
            Assert.assertEquals(users.length, 10);
            Assert.assertEquals(users[3].getUserName(), "User 4");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JacksonTests :: GET @" + Thread.currentThread().getName());
    }

    @Test
    public void deleteUsers(){
        final String endpointName = "/Users/10";
        String url = api + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .method("DELETE", RequestBody.create("", MediaType.get("application/json")))
                .header("accept", "*/*")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            Assert.assertEquals(code, 200, "Responce code must be 200, but got " + code + " instead");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JacksonTests :: DELETE @" + Thread.currentThread().getName());
    }
}