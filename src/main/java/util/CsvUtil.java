/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário para operações simples com arquivos CSV.
 * <p>
 * Esta classe fornece métodos estáticos para salvar itens em arquivos CSV
 * e ler todos os dados de um arquivo CSV para uma lista de strings.
 * Cada linha do arquivo é tratada como um item separado.
 * </p>
 * 
 * @author Ralf
 */
public class CsvUtil {
    
    /**
     * Salva um item em um arquivo CSV.
     * <p>
     * O item será adicionado ao final do arquivo especificado pelo caminho.
     * Caso o arquivo não exista, será criado automaticamente.
     * </p>
     *
     * @param caminho Caminho do arquivo CSV onde o item será salvo
     * @param item    String a ser salva no arquivo
     */
    public static void salvarItem(String caminho, String item) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(item);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lê todos os itens de um arquivo CSV e retorna uma lista de strings.
     * <p>
     * Cada linha do arquivo é adicionada à lista como um item separado, removendo
     * espaços em branco no início e no fim.
     * </p>
     *
     * @param caminho Caminho do arquivo CSV a ser lido
     * @return Lista de strings contendo todas as linhas do arquivo
     */
    public static List<String> lerArquivo(String caminho) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

}
