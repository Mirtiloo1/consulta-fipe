package br.edu.fatecpg.springsemweb.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {
    public ConsomeApi() throws IOException, InterruptedException {
    }

    public static String obterDados(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
    }
}
