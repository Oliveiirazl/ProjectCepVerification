package service;

import com.google.gson.Gson;
import model.Adressmodel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdressService {
    public Adressmodel buscaCep(String cep) {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Adressmodel.class);
        } catch (Exception e) {
            throw new RuntimeException("Nao consegui obter o endereco a partir desse cep");
        }


    }
}
