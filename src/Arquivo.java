import java.io.*;
import java.util.*;

class Arquivo {

    public static Map<String, Object> lerArquivo(String caminho) throws IOException {
        Map<String, Object> dados = new HashMap<>();
        ArrayList<Peca> pecas = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(caminho));

        String[] dimensoes = br.readLine().split(" ");
        int larguraChapa = Integer.parseInt(dimensoes[0]);
        int alturaChapa = Integer.parseInt(dimensoes[1]);
        dados.put("larguraChapa", larguraChapa);
        dados.put("alturaChapa", alturaChapa);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] dadosPeca = br.readLine().split(" ");
            int tipo = Integer.parseInt(dadosPeca[0]);
            int largura = Integer.parseInt(dadosPeca[1]);
            int altura = Integer.parseInt(dadosPeca[2]);
            int quantidade = Integer.parseInt(dadosPeca[3]);
            pecas.add(new Peca(tipo, largura, altura, quantidade));
        }

        dados.put("pecas", pecas);
        br.close();
        return dados;
    }

    public static void escreverArquivo(String caminho, List<String> cortes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
        for (String corte : cortes) {
            bw.write(corte);
            bw.newLine();
        }
        bw.close();
    }
}