package com.example.application.views.termo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Palavra {
    private String palavra;

    public Palavra() {
        this.palavra = lerPalavraAleatoriaDoArquivo();
    }

    public String getPalavra() {
        return palavra;
    }

    private String lerPalavraAleatoriaDoArquivo() {
        List<String> palavras = new ArrayList<>();

        try {
            File file = new File("src/main/java/com/example/application/views/termo/dicionario.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                palavras.add(scan.nextLine());
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!palavras.isEmpty()) {
            Random random = new Random();
            return palavras.get(random.nextInt(palavras.size()));
        } else {
            return "Arquivo de palavras vazio";
        }
    }
}



/*public class Palavra {
    private String palavra = "bunny";
    private String caminho_dicionario;

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

}*/
