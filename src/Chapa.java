import java.util.ArrayList;
class Chapa {

    private int largura;
    private int altura;
    private ArrayList<Plano> planos;
    private ArrayList<String> cortes;

    public Chapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.planos = new ArrayList<>();
        this.planos.add(new Plano(0, 0, largura, altura));
        this.cortes = new ArrayList<>();
    }

    public boolean cortarPeca(Peca peca) {
        for (int i = 0; i < planos.size(); i++) {
            Plano plano = planos.get(i);
            if (plano.podeConter(peca)) {
                // Registrar o corte
                cortes.add(peca.getTipo() + " " + plano.getX() + " " + plano.getY());

                // Atualizar os planos
                planos.remove(i);
                planos.add(new Plano(plano.getX() + peca.getLargura(), plano.getY(), plano.getLargura() - peca.getLargura(), peca.getAltura()));
                planos.add(new Plano(plano.getX(), plano.getY() + peca.getAltura(), plano.getLargura(), plano.getAltura() - peca.getAltura()));

                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCortes() {
        return cortes;
    }
}