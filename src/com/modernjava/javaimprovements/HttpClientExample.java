package com.modernjava.javaimprovements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.google.com"))
                .build();
        
        HttpResponse<String> response = client.send(
                request,HttpResponse.BodyHandlers.ofString());

        System.out.println("response.body() = " + response.body());

    }
}


