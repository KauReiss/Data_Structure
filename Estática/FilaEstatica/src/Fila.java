public class Fila implements EnfileravelInterface {
    private int ponteiroPrimeiro;
    private int ponteiroUltimo;
    private int tamanho;
    private Object[] fila;

    public Fila(int tamanho){
        ponteiroPrimeiro = 0;
        ponteiroUltimo = 0;
        this.tamanho = tamanho;
        fila = new Object[tamanho];
    }

    @Override
    public Boolean estaVazio() {
        return (ponteiroPrimeiro == ponteiroUltimo);
    }

    @Override
    public Boolean estaCheio() {
        return (ponteiroUltimo - ponteiroPrimeiro == tamanho);
    }

    @Override
    public void imprimir() {
        System.out.print("Fila [ ");
        for (int i = ponteiroPrimeiro%5; i < ponteiroUltimo; i++){
            if (ponteiroUltimo > tamanho) {
                System.out.print(fila[i%5] + " ");
            } else {
                System.out.print(fila[i] + " ");
            }
            
        }
        System.out.println("]");
    }

    @Override
    public void entrar(int dado) {
        if (!estaCheio()){
            fila[ponteiroUltimo%5] = dado;
            ponteiroUltimo++;
        } else {
            System.out.println("\n Erro ao entrar na fila \n A fila está cheia! \n");
        }
    }

    @Override
    public void sair() {
        if (!estaVazio()){
            ponteiroPrimeiro = ponteiroPrimeiro%5 + 1;
        } else {
            System.out.println("\n Erro ao tirar elemento da fila\n A fila está vazia!\n");
        }
    }

    @Override
    public int quantElementos() {
        int quantidade = ponteiroUltimo - ponteiroPrimeiro;
        return quantidade;
    }

    public Object primeiroFila(){
        Object dado = null;
        if (!estaVazio()){
            dado = fila[ponteiroPrimeiro];
            return dado;
        } else {
            System.out.println("\n Erro! \n A fila está vazia! ");
            return dado;
        }
    
        
    }

}
