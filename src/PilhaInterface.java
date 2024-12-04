public interface PilhaInterface {

    public abstract Boolean estaCheia();
    public abstract Boolean estaVazia();
    public abstract void inserir(int dado);
    public abstract Object topo();
    public abstract void remover();
    public abstract void imprimir();
    public abstract int qualTamanho();
}