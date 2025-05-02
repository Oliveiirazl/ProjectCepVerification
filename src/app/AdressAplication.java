package app;

import model.Adressmodel;
import service.AdressService;
import service.FileGeneratorService;

import java.io.IOException;
import java.util.Scanner;

public class AdressAplication {
    public static void main(String[] args) {
        AdressService consulta = new AdressService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu cep");
        var cep = scanner.nextLine();

        try {
            Adressmodel newAdress = consulta.buscaCep(cep);
            System.out.println(newAdress);
            FileGeneratorService fileGnerator = new FileGeneratorService();
            fileGnerator.salvaJson(newAdress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Aplicação sendo finalizada");
        }










    }
}
