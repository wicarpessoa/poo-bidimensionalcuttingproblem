import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Lendo o arquivo de entrada
            Map<String, Object> dados = Arquivo.lerArquivo("input.txt");
            int larguraChapa = (int) dados.get("larguraChapa");
            int alturaChapa = (int) dados.get("alturaChapa");
            ArrayList<Peca> pecas = (ArrayList<Peca>) dados.get("pecas");


            Chapa chapa = new Chapa(larguraChapa, alturaChapa);


            for (Peca peca : pecas) {
                for (int i = 0; i < peca.getQuantidade(); i++) {
                    if (!chapa.cortarPeca(peca)) {
                        break;
                    }
                }
            }
            Plotador.plotar(larguraChapa, alturaChapa, chapa.getCortes(), "plano_de_corte.png");
            Arquivo.escreverArquivo("output.txt", chapa.getCortes());
            System.out.println("Arquivo output.txt gerado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}