package org.example.tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WiremockTests {
    int port = 9098;
    OkHttpClient client = new OkHttpClient.Builder().build();

    WireMockServer wireMockServer
            = new WireMockServer(new WireMockConfiguration().port(port));


    @BeforeClass
    public void beforeClass() {
        wireMockServer.start();
        WireMock.configureFor(port);
        WireMock.stubFor(
                WireMock.get(urlEqualTo("/example"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(523)
                                        .withFixedDelay(4522)
                                        .withHeader("Content-Type", "application/json")
                        )
        );
    }

    @AfterClass
    public void afterClass() {
        wireMockServer.stop();
    }

    @Test
    public void checkExample() {
        var request = new Request.Builder()
                .url("http://localhost:" + port + "/example")
                .build();
        try (var response = client.newCall(request).execute()) {
            var code = response.code();
            Assert.assertEquals(code, 523, "We expected 523, but received " + code);
            Assert.assertEquals(response.receivedResponseAtMillis()-response.sentRequestAtMillis(), 4522, "Expected result != Fact");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}