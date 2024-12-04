public class Pilha implements PilhaInterface{

    private int ponteiroTopo;
    private Object[] elementos;


    public Pilha(int tamanho){
        ponteiroTopo = -1;
        elementos = new Object[tamanho];
    }

    @Override
    public Boolean estaCheia() {
        return ( ponteiroTopo == 5);
    }

    @Override
    public Boolean estaVazia() {
        return (ponteiroTopo == -1);
    }

    @Override
    public void inserir(int dado) {
        if (!estaCheia()) {
            ponteiroTopo++;
            elementos[ponteiroTopo] = dado;
        }
    }

    @Override
    public Object topo() {
        Object elementoTopo = null;
        if (!estaVazia()){
            elementoTopo = elementos[ponteiroTopo];
        } else {
            System.out.println("\n Erro ao mostrar o dado do topo \n A Pilha está vazia!");
        }
        return elementoTopo;
    }

    @Override
    public void remover() {
        if (!estaVazia()){
            ponteiroTopo --;
        } else {
            System.out.println("\n Erro ao desempilhar. \n A Pilha está vazia! \n");
        }
    }

    @Override
    public void imprimir() {
        System.out.print("\n Pilha [ ");
        for ( int i = 0 ; i <= ponteiroTopo; i++){
            System.out.print(elementos[i] + " ");
        }
        System.out.println("]\n");
    }

    @Override
    public int qualTamanho() {
        int tamanho = ponteiroTopo + 1;
        return tamanho;
    }

}