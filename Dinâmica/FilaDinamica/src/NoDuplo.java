public class NoDuplo {

    private NoDuplo proximo;
    private NoDuplo anterior;
    private Object elemento;
    
    // Getters e Setters
    public NoDuplo getProximo() {
        return proximo;
    }
    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }
    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
 
}