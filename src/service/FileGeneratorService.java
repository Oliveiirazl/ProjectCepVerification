package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Adressmodel;

import java.io.FileWriter;
import java.io.IOException;

public class FileGeneratorService {

    public void salvaJson(Adressmodel endereco) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileJson = new FileWriter(endereco.cep() + ".json");
        fileJson.write(gson.toJson(endereco));
        fileJson.close();

    }
}


