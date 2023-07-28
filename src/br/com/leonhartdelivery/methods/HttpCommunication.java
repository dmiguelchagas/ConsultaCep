package br.com.leonhartdelivery.methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCommunication {
    public String geraConteudoJson (String pesquisa) throws IOException, InterruptedException {
        String urlSearch = "http://viacep.com.br/ws/" + pesquisa + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlSearch))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
