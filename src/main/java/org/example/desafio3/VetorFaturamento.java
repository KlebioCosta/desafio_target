package org.example.desafio3;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


public class VetorFaturamento {

    public static void main(String[] args) {
        String caminhoJson = "src/main/resources/dados/faturamento.json";

        String json = lerArquivoJson(caminhoJson);

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonArray faturamentoArray = jsonObject.getAsJsonArray("faturamento");

        List<Double> faturamentoDiario = new ArrayList<>();

        for (JsonElement elemento : faturamentoArray) {
            JsonObject diaFaturamento = elemento.getAsJsonObject();
            double valor = diaFaturamento.get("valor").getAsDouble();
            if (valor > 0) faturamentoDiario.add(valor);
        }
        ;

        if (!faturamentoDiario.isEmpty()) {
            double menorValor = Collections.min(faturamentoDiario);
            double maiorValor = Collections.max(faturamentoDiario);

            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;
            for (double valor : faturamentoDiario) {
                somaFaturamento += valor;
                diasComFaturamento++;
            }
            ;

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (double valor : faturamentoDiario) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
                ;

            }
            ;

            System.out.printf("Menor faturamento: %s\n", menorValor);
            System.out.printf("Maior faturamento: %s\n", maiorValor);
            System.out.printf("Quantidade de dias com faturamento acima da media mensal: %s", diasAcimaDaMedia);
        } else {
            System.out.println("Não possui valores para serem processados. ");
        }
    }

    private static String lerArquivoJson (String caminhoJson){
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoJson))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append((linha));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    };

};


