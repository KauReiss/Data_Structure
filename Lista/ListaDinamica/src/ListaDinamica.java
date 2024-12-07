public class ListaDinamica implements ListaInterface{
    
    private NoDuplo ponteiroPrimeiro;
    private NoDuplo ponteiroUltimo;
    private int quantidade;
    private int tamanho;


    public ListaDinamica(int tamanho) {
        this.tamanho = tamanho;
        ponteiroPrimeiro = null;
        ponteiroUltimo = null;
        quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public void inserir(int dado, int posicao) {
        if (!estaCheio()){
            if (quantidade == 0){
                NoDuplo noNovo = new NoDuplo();
                noNovo.setElemento(dado);
                ponteiroPrimeiro = noNovo;
                ponteiroUltimo = noNovo;
                quantidade++;
                System.out.println(ponteiroPrimeiro.getElemento());
                System.out.println(ponteiroUltimo.getElemento());
                System.out.println(quantidade);
            } else if ( posicao == quantidade + 1) {
                NoDuplo noNovo = new NoDuplo();
                noNovo.setElemento(dado);
                if (quantidade == 1){
                    ponteiroPrimeiro.setProximo(noNovo);
                } else {
                    ponteiroUltimo.setProximo(noNovo);
                }
                noNovo.setAnterior(ponteiroUltimo);
                ponteiroUltimo = noNovo;
                quantidade++;
                System.out.println(ponteiroPrimeiro.getElemento());
                System.out.println(ponteiroUltimo.getElemento());
                System.out.println(quantidade);
                System.out.println(ponteiroPrimeiro.getProximo());
            } else {
                NoDuplo noNovo = new NoDuplo();
                noNovo.setElemento(dado);
                NoDuplo aux = ponteiroPrimeiro;
                for (int i = 0; i != posicao -1; i++){
                    aux = aux.getProximo();
                }
                NoDuplo auxProximo = aux.getProximo();
                auxProximo.setAnterior(noNovo);
                aux.setProximo(noNovo);
                quantidade++;
            }
        } else {
            System.out.println("\n Erro! A lista está cheia! \n");
        }
    }


    @Override
    public void remover(int posicao) {
        if (!estaVazio()){
            if (posicao > quantidade || posicao <= 0) {
                System.out.println("\n Erro! Insira uma posição válida! \n");
            } else if (posicao == 1) {
                NoDuplo aux = ponteiroPrimeiro.getProximo();
                ponteiroPrimeiro.setProximo(null);
                ponteiroPrimeiro.setElemento(null);
                ponteiroPrimeiro = aux;
                quantidade--;
            } else if (posicao == quantidade){
                NoDuplo aux = ponteiroUltimo.getAnterior();
                ponteiroUltimo.setAnterior(null);
                ponteiroUltimo.setElemento(null);
                ponteiroUltimo = aux;
                quantidade--;
            } else {
                NoDuplo aux = ponteiroPrimeiro;
                for (int i = 0; i != posicao - 1; i++) {
                    aux = aux.getProximo();
                }
                NoDuplo auxAnterior = aux.getAnterior();
                NoDuplo auxProximo = aux.getProximo();
                aux.setAnterior(null);
                aux.setProximo(null);
                aux.setElemento(null);
                auxProximo.setAnterior(auxAnterior);
                auxAnterior.setProximo(auxProximo);
                quantidade--;
            }
        } else {
            System.out.println("\n Erro! A lista está vazia! \n");
        }

    }


    @Override
    public void atualizar(int dado, int posicao) {
        NoDuplo aux = ponteiroPrimeiro;
        if (!estaVazio()){
            if (posicao > quantidade || posicao <= 0){
                System.out.println("\n Erro! Insira uma posição válida! \n");
            } else {
                for (int i = 0; i != posicao -1; i++){
                    aux = aux.getProximo();
                }
                aux.setElemento(dado);
            }
        } else {
            System.out.println("\n Erro! A lista está vazia! \n");
        }
    }

    @Override
    public String quantElementos() {
        String text = "\n A lista tem "+ quantidade + " elementos. \n";
        return text;
    }


    @Override
    public void limpar() {
        ponteiroPrimeiro = null;
        ponteiroUltimo = null;
        quantidade = 0;
    }


    @Override
    public void imprimir() {
        NoDuplo aux = ponteiroPrimeiro;
        System.out.print("\n Lista [ ");
        for (int i = quantidade ; i > 0 ; i--) {
            System.out.print(aux.getElemento()+ " ");
            aux = aux.getProximo();
        }
        System.out.print("]\n");
    }


    @Override
    public Boolean estaVazio() {
        return (quantidade == 0);
    }


    @Override
    public Boolean estaCheio() {
        return (quantidade == tamanho);
    }
}
