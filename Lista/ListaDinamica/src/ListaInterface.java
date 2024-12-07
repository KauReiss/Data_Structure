public interface ListaInterface {
    
    public void inserir(int dado, int posicao);
    public void remover(int posicao);
    public void atualizar(int dado, int posicao);
    public String quantElementos();
    public void limpar();

    public void imprimir();
    public Boolean estaVazio();
    public Boolean estaCheio();
}
