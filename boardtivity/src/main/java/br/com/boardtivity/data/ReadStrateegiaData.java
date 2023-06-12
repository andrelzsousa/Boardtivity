package br.com.boardtivity.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStrateegiaData {
    public static void main(String[] args) {
        String nomeArquivo = "C:\\Users\\andre\\Desktop\\data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}