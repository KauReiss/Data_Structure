public class FilaDinamica implements FilaInterface {
    
    private NoDuplo ponteiroPrimeiro;
    private NoDuplo ponteiroUltimo;
    private int tamanho;
    private int quantidade;

    public FilaDinamica(int tamanho){
        this.tamanho = tamanho;
        ponteiroPrimeiro = null;
        ponteiroUltimo = null;
        quantidade = 0;
    }

    @Override
    public void entrar(int dado) {
        NoDuplo aux = ponteiroUltimo;
        if (!estaCheio()) {
            NoDuplo noNovo = new NoDuplo();
            noNovo.setElemento(dado);
            if (quantidade < 1) {
                ponteiroPrimeiro = noNovo;
            } else {
                ponteiroUltimo.setAnterior(noNovo);
            }
            noNovo.setProximo(aux);
            ponteiroUltimo = noNovo;
            quantidade++;
        } else {
            System.out.println("A fila está cheia!");
        }
    }

    @Override
    public void sair() {
        if (!estaVazia()){
            NoDuplo aux = ponteiroPrimeiro.getAnterior();
            if (quantidade > 1){
                aux.setProximo(null);
                ponteiroPrimeiro.setAnterior(null);
                ponteiroPrimeiro = aux;
            } else {
                ponteiroPrimeiro = aux;
            }
            quantidade--;
        } else {
            System.out.println("\n A fila está vazia! \n");
        }
    }

    @Override
    public Object primeiroFila() {
        if (!estaVazia()){
            Object first = ponteiroPrimeiro.getElemento();
            return first;
        } else {
            Object first = null;
            System.out.println("\n A fila está vazia! \n");
            return first;
        }
        
    }

    @Override
    public void imprimir() {
        NoDuplo aux = ponteiroPrimeiro;
        System.out.print("\n Fila [ ");
        for (int i = quantidade; i > 0; i--){
            System.out.print(aux.getElemento() + " ");
            aux = aux.getAnterior();
        }
        System.out.println("]");
    }

    @Override
    public Boolean estaCheio() {
        return (quantidade == tamanho);
    }

    @Override
    public Boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String qualTamanho() {
        String tamanho = "\n A fila tem " + quantidade + " elementos. \n";
        return tamanho;
    }


}
