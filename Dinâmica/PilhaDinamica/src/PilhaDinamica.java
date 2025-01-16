public class PilhaDinamica implements PilhaInterface {
    private int tamanho;
    private int quantidade;
    private NoDuplo ponteiroTopo;
    
    public PilhaDinamica (int tamanho){
        this.tamanho = tamanho;
        quantidade = 0;
        ponteiroTopo = null;    
    }
    
    @Override
    public Boolean estaCheia() {
        return (quantidade == tamanho);
    }
    @Override
    public Boolean estaVazia() {
        return (ponteiroTopo == null);
    }
    @Override
    public void inserir(int dado) {
        if (!estaCheia()){
            NoDuplo noNovo = new NoDuplo();
            noNovo.setElemento(dado);
            noNovo.setAnterior(ponteiroTopo);
            if (!estaVazia()) {
                ponteiroTopo.setProximo(noNovo);
            }
            ponteiroTopo = noNovo;
            quantidade++;
        } else {
            System.out.println("\n A pilha está cheia! \n");
        }
    }

    @Override
    public void remover() {
        if (!estaVazia()){
            ponteiroTopo = ponteiroTopo.getAnterior();
            if (quantidade > 1){
                ponteiroTopo.setProximo(null);  //Removendo referência ao nó para a região de memória ser eliminada
            }
            quantidade --;
        } else {
            System.out.println("\n A pilha está vazia! \n");
        }
    }

    @Override
    public Object topo() {
        if (!estaVazia()) {
            Object elemento = ponteiroTopo.getElemento();
            return elemento;  
        } else {
            System.out.println("\n A pilha está vazia! \n");
            Object elemento = null;
            return elemento;
        }
    }

    @Override
    public void imprimir() {
        NoDuplo aux = ponteiroTopo;
        System.out.print("Pilha [ ");
        for(int i = quantidade ; i > 0; i--){
            System.out.print(aux.getElemento() + " ");
            aux = aux.getAnterior();
        }
        System.out.println("]");
        
    }
    @Override
    public String qualTamanho() {
        String quantos = "\n A pilha tem " + quantidade + " elementos. \n" ;
        return quantos;
    }


}
