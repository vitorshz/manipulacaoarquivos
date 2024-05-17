
package br.unipar.manipulacao.arquivos.atividadediferente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ManipulacaoArquivos {

    public static void main(String[] args) throws IOException {
        
        File d = new File("C:\\tabuaada");
          
        d.mkdir();
            
        if (!d.exists()) {
            d.mkdir();
        }

        File tabuada = new File("C:\\tabuaada\\tabuada.txt");

        try {
            // Criação do arquivo
            if (tabuada.exists()) {
                System.out.println("O arquivo já existe. Será excluído.");
                tabuada.delete();
            }
            tabuada.createNewFile();

            // Escrita da tabuada no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tabuada))) {
                for (int i = 1; i <= 10; i++) {
                    writer.write(i + " x 9 = " + (i * 9) + "\n");
                }
                System.out.println("Tabuada do 9 foi escrita no arquivo.");
            } catch (IOException ex) {
                System.out.println("Erro ao escrever no arquivo: " + ex.getMessage());
            }

            // Leitura e impressão do arquivo
            try (BufferedReader reader = new BufferedReader(new FileReader(tabuada))) {
                System.out.println("Conteúdo do arquivo:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ex) {
                System.out.println("Erro ao ler o arquivo: " + ex.getMessage());
            }

            // Exclusão do arquivo
            if (tabuada.exists()) {
                tabuada.delete();
                System.out.println("Arquivo excluído com sucesso.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
