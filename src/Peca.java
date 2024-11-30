class Peca {
    private int tipo;
    private int largura;
    private int altura;
    private int quantidade;

    public Peca(int tipo, int largura, int altura, int quantidade) {
        this.tipo = tipo;
        this.largura = largura;
        this.altura = altura;
        this.quantidade = quantidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}